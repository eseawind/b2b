var OUTLOOKBAR_DEFINITION = {
	format:{
		target:'main',
		blankImage:'/images/b.gif',
		rollback:true,
		animationSteps:3,
		animationDelay:20,
		templates:{
			panel:{
				normal:'<div style="background: right top url(/images/panel_right.gif);"><div style="background: left top no-repeat url(/images/panel_left.gif); padding: 7px 13px 0 13px; font: bold 11pt arial; text-align: center; height: 30px;">{text}</div></div>',
				rollovered:'<div style="background: right top url(/images/panel_right_r.gif);"><div style="background: left top no-repeat url(/images/panel_left_r.gif); padding: 7px 13px 0 13px; font: bold 11pt arial; text-align: center; height: 30px;">{text}</div></div>'
			},
			item:{
				normal:'<div style="padding-right: 1px;"><div style="padding: 10px 0 15px 0; text-align: center; font: 9pt verdana; background: #FFFFFF left bottom repeat-x url(/images/div.gif);"><img src="/admin/images/{icon}.gif" width="59" height="54" /><br />{text}</div></div>',
				rollovered:'<div style="padding-right: 1px;"><div style="padding: 10px 0 15px 0; text-align: center; font: 9pt verdana; background: #EEEFFF left bottom repeat-x url(/images/div.gif);"><img src="/admin/images/{icon}_r.gif" width="59" height="54" /><br />{text}</div></div>'
			},
			upArrow:{
				normal:'<img src="/admin/images/up.gif" width="28" height="28" />',
				rollovered:'<img src="/admin/images/up_r.gif" width="28" height="28" />'
			},
			downArrow:{
				normal:'<img src="/admin/images/down.gif" width="28" height="28" />',
				rollovered:'<img src="/admin/images/down_r.gif" width="28" height="28" />'
			}
		}
	},
	panels:[
		{text:"жаЭт", 
			items:[
				{text:"Apple", icon:'apple', url:'dummy.html?id=2'},
				{text:"Banana", icon:'banana', url:'dummy.html?id=3'},
				{text:"Orange", icon:'orange', url:'dummy.html?id=4'},
				{text:"Mango", icon:'mango', url:'dummy.html?id=5'}
			]
		},
		{text:"Flowers",
			items:[
				{text:"Rose", icon:'rose', url:'dummy.html?id=7'},
				{text:"Sunflower", icon:'sunflower', url:'dummy.html?id=8'},
				{text:"Tulip", icon:'tulip', url:'dummy.html?id=9'},
				{text:"Daisy", icon:'daisy', url:'dummy.html?id=10'}
			]
		}
	]
}
