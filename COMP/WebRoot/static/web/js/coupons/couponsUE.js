$(function(){
	var ue = UE.getEditor('introduce', {
        initialFrameWidth : 730 ,
        initialFrameHeight: 250 ,
	    toolbars: [
	         [
		        'anchor',  
		        'undo',  
		        'redo',  
		        'bold',   
		        'italic',  
		        'underline',  
		        'strikethrough', 
		        'subscript',  
		        'fontborder',  
		        'superscript',  
		        'formatmatch',     
		        'preview',  
		        'horizontal',  
		        'removeformat', 
		        'unlink',      
		        'inserttitle',     
		        'fontfamily', 
		        'fontsize',  
		        'simpleupload',  
		        'insertimage',  
		        'link',  
		        'emotion', 
		        'spechars',  
		        'justifyright', 
		        'justifycenter', 
		        'justifyjustify',  
		        'forecolor', 
		        'backcolor',  
		        'fullscreen', 
		        'customstyle',  
		        'autotypeset',  
		    ]
	    ],
	    autoHeightEnabled: false ,
	    autoFloatEnabled: true
	});
	
});