/*
 * Ext JS Library 2.0
 * Copyright(c) 2006-2007, Ext JS, LLC.
 * licensing@extjs.com
 * 
 * http://www.extjs.com/license
 */



/*
 * Use our blank image
 */
Ext.BLANK_IMAGE_URL = 'css/images/s.gif';



/* ***********************************************************************
 * Desktop
 */
Ext.Desktop = function(taskbar){
	this.taskbar = new Ext.ux.TaskBar();
	var taskbar = this.taskbar;
	
	var desktopEl = Ext.get('x-desktop');
    var taskbarEl = Ext.get('ux-taskbar');

    var windows = new Ext.WindowGroup();
    var activeWindow;
		
    function minimizeWin(win){
        win.minimized = true;
        win.hide();
    }

    function markActive(win){
        if(activeWindow && activeWindow != win){
            markInactive(activeWindow);
        }
        taskbar.setActiveButton(win.taskButton);
        activeWindow = win;
        Ext.fly(win.taskButton.el).addClass('active-win');
        win.minimized = false;
    }

    function markInactive(win){
        if(win == activeWindow){
            activeWindow = null;
            Ext.fly(win.taskButton.el).removeClass('active-win');
        }
    }

    function removeWin(win){
    	taskbar.removeTaskButton(win.taskButton);
        layout();
    }

    function layout(){
        desktopEl.setHeight(0);
    }
    Ext.EventManager.onWindowResize(layout);

    this.layout = layout;

    this.createWindow = function(config, cls){
    	var win = new (cls||Ext.Window)(
            Ext.applyIf(config||{}, {
                manager: windows,
                minimizable: true,
                maximizable: true
            })
        );
        win.render(desktopEl);
        win.taskButton = taskbar.addTaskButton(win);

        win.cmenu = new Ext.menu.Menu({
            items: [

            ]
        });

        win.animateTarget = win.taskButton.el;
        
        win.on({
        	'activate': {
        		fn: markActive
        	},
        	'beforeshow': {
        		fn: markActive
        	},
        	'deactivate': {
        		fn: markInactive
        	},
        	'minimize': {
        		fn: minimizeWin
        	},
        	'close': {
        		fn: removeWin
        	}
        });
        
        layout();
        return win;
    };

    this.getManager = function(){
        return windows;
    };

    this.getWindow = function(id){
        return windows.get(id);
    }
    
    this.getWinWidth = function(){
		var width = Ext.lib.Dom.getViewWidth();
		return width < 200 ? 200 : width;
	}
		
	this.getWinHeight = function(){
		var height = (Ext.lib.Dom.getViewHeight()-taskbarEl.getHeight());
		return height < 100 ? 100 : height;
	}
		
	this.getWinX = function(width){
		return (Ext.lib.Dom.getViewWidth() - width) / 2
	}
		
	this.getWinY = function(height){
		return (Ext.lib.Dom.getViewHeight()-taskbarEl.getHeight() - height) / 2;
	}

    layout();
};



/* ***********************************************************************
 * App
 */
Ext.app.App = function(cfg){
    Ext.apply(this, cfg);
    this.addEvents({
        'ready' : true,
        'beforeunload' : true,
        'sessionexpire': true
    });

    Ext.onReady(this.initApp, this);
};

Ext.extend(Ext.app.App, Ext.util.Observable, {
    isReady: false,
    startMenu: null,
    modules: null,

    initApp : function(){
    	this.desktop = new Ext.Desktop();
		
		this.launcher = this.desktop.taskbar.startMenu;
		
		this.modules = this.getModules();
        if(this.modules){
            this.initModules(this.modules);
        }
		
        this.init();

        Ext.EventManager.on(window, 'beforeunload', this.onUnload, this);
		this.fireEvent('ready', this);
        this.isReady = true;
    },

    getModules : Ext.emptyFn,
    init : Ext.emptyFn,

    initModules : function(ms){
		for(var i = 0, len = ms.length; i < len; i++){
            var m = ms[i];
            this.launcher.add(m.launcher);
            m.app = this;
        }
    },
    
    getModule : function(name){
    	var ms = this.modules;
    	for(var i = 0, len = ms.length; i < len; i++){
    		if(ms[i].appType == name){
    			return ms[i];
			}
        }
        return '';
    },

    onReady : function(fn, scope){
        if(!this.isReady){
            this.on('ready', fn, scope);
        }else{
            fn.call(scope, this);
        }
    },

    getDesktop : function(){
        return this.desktop;
    },

    onUnload : function(e){
        if(this.fireEvent('beforeunload', this) === false){
            e.stopEvent();
        }
    }
});



/* ***********************************************************************
 * Module
 */
Ext.app.Module = function(config){
    Ext.apply(this, config);
    Ext.app.Module.superclass.constructor.call(this);
    this.init();
}

Ext.extend(Ext.app.Module, Ext.util.Observable, {
    init : function(){

    }
});