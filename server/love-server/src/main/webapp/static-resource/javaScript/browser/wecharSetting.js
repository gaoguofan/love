jQuery(function(){
  jQuery('.style_type span').click(function(){
	 jQuery(this).addClass('active').siblings().removeClass('active');
	 jQuery('.editor_left>ul').eq(jQuery(this).index()).show().siblings('ul').hide()    
	 
	 jQuery('.editor_left ul').each(function(){
		if(jQuery(this).css("display")!="none"){
			jQuery(this).find('img').each(function(){
				  if(jQuery(this).width()>320){
					  jQuery(this).attr("style","width:95%")		  
				  }	else{
					  return
				  }
				})
		 }
	  })
  })
  
  //取颜色
  
  jQuery(".editor_left_head_right span").click(function(){
	  var color=jQuery(this).css('background-color');
	  add(color)
  })
})

function add(color){
	jQuery('.editor_left>ul').each(function(e){
		 if(jQuery(this).css("display")!="none"){
			 jQuery(this).find("li .96wx-bgc").css("background-color",color);
			 jQuery(this).find("li .96wx-bdc").css("border-color",color)
			 jQuery(this).find("li .96wx-bdtc").css("border-top-color",color)
			 jQuery(this).find("li .96wx-bdbc").css("border-bottom-color",color)
			 jQuery(this).find("li .96wx-color").css("color",color)
			 jQuery(this).find("li p").css("color",color)
			 jQuery(this).find("li .wx_1").css("background-color",color);
			 jQuery(this).find("li .wx_2").css("background-color",color);
			 jQuery(this).find("li .96wx-bdlc").css("border-left-color",color)
			 jQuery(this).find("li .96wx-bdlc,li .96wx-bdrc").css("border-right-color",color)			 
		 }  	  	  
	  })
}

		jQuery(document).ready( function() {		
			jQuery('.demo').each( function() {
				jQuery(this).minicolors({
					control: $(this).attr('data-control') || 'hue',
					defaultValue: $(this).attr('data-defaultValue') || '',
					inline: $(this).attr('data-inline') === 'true',
					letterCase: $(this).attr('data-letterCase') || 'lowercase',
					opacity: $(this).attr('data-opacity'),
					position: $(this).attr('data-position') || 'bottom left',
					change: function(hex, opacity) {
						var log;
						try {
							log = hex ? hex : 'transparent';
							if( opacity ) log += ', ' + opacity;
							var c=log;
							add(c)
						} catch(e) {}
					},
					theme: 'default'
				});
                
            });
			
		});
		
		


var isIE=!!document.all,ieRange=false,editor,win,doc,txt; 
window.onload=function(){ 
  editor=document.getElementById('ueditor_0'); 
  win=editor.contentWindow; 
  doc=win.document; 
  doc.designMode='On';//可编辑 
  win.focus(); 
} 

function insert(that){ 
  if(ieRange){ 
    ieRange.pasteHTML(txt); 
    ieRange.select();ieRange=false;//清空下range对象 
  } 
  else{//焦点不在html编辑器内容时 
     win.focus(); 
     if(isIE)doc.body.innerHTML+=txt;//IE插入在最后 
     else{//Firefox 
       var sel=win.getSelection(),rng=sel.getRangeAt(0),frg=rng.createContextualFragment(jQuery(that).html()); 
       rng.insertNode(frg); 
     } 
  } 
} 

 
     jQuery(function(){
	   jQuery('.webchat_set_content_center_button .img_save').click(function(){
	     init();
	     var that=this;
	     createNode(that)
	     
	   })
	 })
	 
	 function init(){
	    jQuery('.myslidetwo li,.label li').remove();
		 jQuery('.arrows').hide();
		
	 }

    function createNode(that){
	  var parent=jQuery(that).parents('.right_content');
	  var count=parent.find('.webchat_set_content_center li').size(); 	 
      var this_ul=parent.find('.myslide ul');	
       if(this_ul.find('li').length==0){
         for(i=0;i<=count-2;i++){			
	       jQuery('.myslide ul').append("<li></li>");
		   var src_=parent.find(".webchat_set_content_center li>img").eq(i).attr("src")
		  jQuery('.myslide ul li').eq(i).append("<img src='"+src_+"'>");
		   jQuery('.label').append("<li>"+parseInt(i+1)+"</li>")
		   jQuery('.label li:nth-child(1)').addClass('current');
		  jQuery('.arrows').show(); 
	      } 
        }else{
	      return
	    }  
       
       slider();
       var len=jQuery(".label li").length;
       switch(len){
         case 1:
        	 jQuery(".label").attr("style","left:110px");
        	 break
         case 2:
        	 jQuery(".label").attr("style","left:100px");
        	 break
         case 3:
        	 jQuery(".label").attr("style","left:90px");
        	 break
         case 4:
        	 jQuery(".label").attr("style","left:80px");
        	 break
         case 5:
        	 jQuery(".label").attr("style","left:70px");
        	 break
         case 6:
        	 jQuery(".label").attr("style","left:60px");
        	 break
         case 7:
        	 jQuery(".label").attr("style","left:50px");
        	 break
         case 8:
        	 jQuery(".label").attr("style","left:40px");
        	 break
         case 9:
        	jQuery(".label").attr("style","left:30px");
        	 break
         case 10:
         	jQuery(".label").attr("style","left:20px");
         	 break
         default:
        	 jQuery(".label").attr("style","left:10px");
         	 break
       }
	}
	
	function slider(){
	        var _now=0;
            var numl = jQuery(".label li");
            var wid = jQuery(".myslide").eq(0).width();
            var oul = jQuery(".myslidetwo");
            numl.click(function () {
                var index = jQuery(this).index();
                jQuery(this).addClass("current").siblings('li').removeClass("current");
                oul.stop(true,true).css('transform', "translate3d("+(-wid * index)+"px,0,0)");
				_now = index;
            })
            
            jQuery(".pre").click(function () {          
                if (_now==0){
				   _now=numl.size()-1
			    }else{ 
				  _now--
				};
                ani();
            });
            jQuery(".next").click(function () {            
                if (_now == numl.size() - 1) {
                    _now = 0;
                }else {
				  _now++;
				 }
                ani();
            });
            
            function ani(){
                numl.eq(_now).addClass("current").siblings('li').removeClass("current");
                oul.stop(true,true).css('transform', "translate3d("+(-wid * _now)+"px,0,0)");
                
            }		
	}
	
   //tab
   jQuery(function(){
	   init();
	  createNode(jQuery(".right_content").eq(0).find(".webchat_set_content_center").find(".img_save"))
      jQuery('.webchat_set_content_left>ul li').click(function(){
    	 
	      jQuery(this).addClass('active').siblings().removeClass('active');
		  jQuery(".right_content").eq(jQuery(this).index()).show("200").siblings(".right_content").hide("200")  
   		  
		 jQuery(".myslidetwo").css("transform","translate3d(0px, 0px, 0px)")
		  function hideSwiper(){
		   	 jQuery('.myslidetwo,.arrows,.label').hide()
	      }
		  function showSwiper(){
			 jQuery('.myslidetwo,.arrows,.label').show()
	      }
	
		 if(jQuery(this).index()=="2"){
			jQuery(".phone_ul li").eq(0).show().siblings("li").hide()
		    deal_index(0)
		    hideSwiper()
		 }else if(jQuery(this).index()=="0"){
			 jQuery(".phone_ul li").eq(1).show().siblings("li").hide()
			  showSwiper()
			  init();
			 jQuery(".phone_ul li").removClass("active")
   		     createNode(jQuery(".right_content").eq(0).find(".webchat_set_content_center").find(".img_save"))
			 
		 }else if(jQuery(this).index()=="3"){	
            deal_index(1)
           jQuery(".phone_ul li").eq(1).show().siblings("li").hide()
            hideSwiper()
		 }else if(jQuery(this).index()=="4"){	
            deal_index(2)
           jQuery(".phone_ul li").eq(1).show().siblings("li").hide()
            hideSwiper()
		}else if(jQuery(this).index()=="1"){
		  showSwiper()	
		  jQuery(".phone_ul li").removeClass("active")
		 jQuery(".phone_ul li").eq(1).show().siblings("li").hide()
		  init();
   		  createNode(jQuery(".right_content").eq(1).find(".webchat_set_content_center").find(".img_save"))
   		
		}
		else{
			  jQuery(".phone_ul").hide();
			  init();
	   		  createNode(jQuery(".right_content").eq(0).find(".webchat_set_content_center").find(".img_save"))	 
		}
	    function deal_index(num){
		   jQuery(".phone_ul").show();
		   jQuery('.phone_ul li').eq(num).addClass('active').siblings().removeClass('active');
		   jQuery('.tab_div').css('background','#f69994');
		   jQuery(".tab_div_content").eq(num).show("200").siblings(".tab_div_content").hide("200")  
	    }
	 })
	  jQuery(".phone_ul li").eq(0).hide()
	  jQuery(".phone_ul li").click(function(){
	    jQuery(this).addClass('active').siblings().removeClass('active');
	    jQuery(".tab_div_content").eq(jQuery(this).index()).show("200").siblings(".tab_div_content").hide("200") 
	    if(jQuery(this).index()=="0"){
            
	    	jQuery(".phone_ul li").eq(0).hide()
		    deal_index(2)
		   
		 }else if(jQuery(this).index()=="1"){	
			if(jQuery(this).text()=="热销商品"){
				jQuery(".webchat_set_content_left>ul li").eq(3).click()
			}
            deal_index(3)		        
		 }else if(jQuery(this).index()=="2"){	
            deal_index(4)
		}
	    function deal_index(num){
		   jQuery(".right_content").eq(num).show("200").siblings(".right_content").hide("200")  
	    }
	  })
   })
   
   function prewidth(that){
	   var wid=jQuery(window).width();
	      switch(wid){
	        case 1272:
	    	    jQuery(that).parents(".right_content").find('.webchat_set_content_center').animate({
	  			 "width":"56%"},500);
	    	    break;
	       case 1352:
	    	  jQuery(that).parents(".right_content").find('.webchat_set_content_center').animate({
	   			 "width":"57.6%"},500);
	    	  break;
	       case 1358:
	     	  jQuery(that).parents(".right_content").find('.webchat_set_content_center').animate({
	    			 "width":"58.1%"},500);
	     	  break;
	       case 1392:
	     	  jQuery(that).parents(".right_content").find('.webchat_set_content_center').animate({
	    			 "width":"59.5%"},500);
	     	  break;
	       case 1432:
	     	  jQuery(that).parents(".right_content").find('.webchat_set_content_center').animate({
	    			 "width":"61%"},500);
	     	  break;
	       case 1592:
	     	  jQuery(that).parents(".right_content").find('.webchat_set_content_center').animate({
	    			 "width":"65%"},500);
	     	  break;
	       case 1672:
	      	  jQuery(that).parents(".right_content").find('.webchat_set_content_center').animate({
	     			 "width":"66%"},500);
	      	  break ;
	       case 1920:
		    	 jQuery(that).parents(".right_content").find('.webchat_set_content_center').animate({
	     			 "width":"70%"},500);
	      	  break ;
	       }   
   }
   
   function newwidth(that){
	   var wid=jQuery(window).width();
	      switch(wid){
	        case 1272:
	    	    jQuery(that).parents(".right_content").find('.webchat_set_content_center').animate({
	  			 "width":"54.4%"},500);
	    	    break;
	       case 1352:
	    	  jQuery(that).parents(".right_content").find('.webchat_set_content_center').animate({
	   			 "width":"57%"},500);
	    	  break;
	       case 1358:
	     	  jQuery(that).parents(".right_content").find('.webchat_set_content_center').animate({
	    			 "width":"57.3%"},500);
	     	  break;
	       case 1392:
	     	  jQuery(that).parents(".right_content").find('.webchat_set_content_center').animate({
	    			 "width":"58.3%"},500);
	     	  break;
	       case 1592:
	     	  jQuery(that).parents(".right_content").find('.webchat_set_content_center').animate({
	    			 "width":"48.7%"},500);
	     	  break;
	      
	       case 1672:
	      	  jQuery(that).parents(".right_content").find('.webchat_set_content_center').animate({
	     			 "width":"50%"},500);
	      	  break ;
	       case 1920:
		    	 jQuery(that).parents(".right_content").find('.webchat_set_content_center').animate({
	     			 "width":"55.6%"},500);
	      	  break ;
	       }	  
   }
   
 
   jQuery(function(){
	
	   //使用说明伸缩
	    jQuery('.dir').click(function(){
	      if(jQuery(this).css('transform')=="matrix(1, 0, 0, 1, 0, 0)"){
	        jQuery(this).parent(".webchat_set_content_right").css('transform','translate3d(160px, 0, 0)');
		    jQuery(this).css("transform","rotate(180deg)");
		    prewidth(this)
		  }else{
		    jQuery(this).parent(".webchat_set_content_right").css('transform','translate3d(0px, 0, 0)');
		    jQuery(this).css("transform","rotate(0deg)");
		    newwidth(this)
		 }
	    })
		//添加名师推荐
		jQuery('.add_famous_content_1').click(function(){  
		 if(jQuery(this).find('img').css('display')=="none"){
		   jQuery(this).find('.add_famous_content_1_top>img').show();
		   jQuery(this).addClass('img_show')
		  }else{
		    jQuery(this).find('.add_famous_content_1_top>img').hide();
		    jQuery(this).removeClass('img_show')
		   }
		})
	  }) 
   