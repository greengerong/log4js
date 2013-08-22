

   //兼容 json;

   window.logLevel = {
   	 debug:{text:"debug",value:0},
   	 info:{text:"info",value:1},
   	 warn:{text:"warn",value:2},
   	 error:{text:"error",value:3},
   	 all:{text:"all",value:-1},
   	 off:{text:"off",value:4}
   };
   

(function($, window){

	function logger(basicInfo){
		var me = this;
		var id = "com-github-greengerong-log4js-alert";
		var alertCss = {
				alert :"padding: 8px 35px 8px 14px;margin:-10px;text-shadow: 0 1px 0 rgba(255, 255, 255, 0.5);background-color: #fcf8e3;border: 1px solid #fbeed5;-webkit-border-radius: 4px;-moz-border-radius: 4px;border-radius: 4px;color: #c09853;",
				close :"padding: 0;cursor: pointer;background: transparent;border: 0;-webkit-appearance: none;float: right;font-size: 20px;font-weight: bold;line-height: 20px;color: #000000;text-shadow: 0 1px 0 #ffffff;opacity: 0.2;filter: alpha(opacity=20);font-family: Helvetica Neue, Helvetica, Arial, sans-serif;",
				content : "padding: 0;margin: 0 0 10px 25px;display: block;list-style-type: disc;-webkit-margin-before: 1em;-webkit-margin-after: 1em;-webkit-margin-start: 0px;-webkit-margin-end: 0px;-webkit-padding-start: 40px;list-style-type:decimal;"
			};

		me._getBasicInfo = function() {
		  return  window.basicInfo;
		};

		me._post = function(level,msg,data){
			var obj = {
				level : level,
				msg : 	msg
			};
			if(data){
				obj.data = window.JSON.stringify(data);
			}

			me._beforeLog(obj);
			var projectLevel = window.logLevel[me._getBasicInfo().logLevel];
			
			if(level.value >= projectLevel.value){
				me._beforePost(obj);
				me._send(obj);
			}
		};
		me._beforeLog =function (obj) {
			var projectLevel = window.logLevel[me._getBasicInfo().logLevel];
			if(projectLevel.value > window.logLevel.debug.value){
				return;
			}

			var $alert = $("#" + id).show();

			 if($alert.length === 0){
				 $alert = $('<div id="' + id + '" class="alert" style="' + alertCss.alert + '">' +
	            '  <strong >Client error : </strong><ul class="content" style="' +  alertCss.content +'">' +
	            '</ul></div>').prependTo(document.body);
    		  }

    		$("<li style='line-height: 20px;'></li>").appendTo($alert.find("ul.content"))
    					  .text(window.JSON.stringify(obj))
    		              .append('<button type="button" class="close" style="' + alertCss.close + '">×</button>')
    		              .find("button.close").bind("click",function(){
	            				$(this).parent().remove();
	            				if($alert.find("ul li").length === 0 ){
	            					$alert.hide();
	            				}
           				  });
    		//$alert.show();
		};

		me._beforePost = function(obj){
    
		};

		me._done = function(obj,args){
			
		};

		me._error = function(obj,args){
			
		};

		me._success = function(obj,args){
			
		};


		me._send = function(obj){
			$.post(me._getBasicInfo().logUrl, obj, function() {
			  if(me._success){
					me._success(obj,arguments);
				}
			})
			.fail(function() { 
				if(me._error){
					me._error(obj, arguments);
				}
			 })
			.done(function(){
				if(me._done){
					me._done(obj, arguments);
				}
			});
		};

		me.debug =function(msg,data){
			me._post(window.logLevel.debug, msg, data);
		};

		me.info =function(msg,data){
			me._post(window.logLevel.info, msg, data);
		};

		me.warn =function(msg,data){
			me._post(window.logLevel.warn, msg, data);
		};

		me.error =function(msg,data){
			me._post(window.logLevel.error, msg, data || "");
		};
	}

	
	var _logger= new logger();
	$.extend({
		debug:_logger.debug,
		info:_logger.info,
		warn:_logger.warn,
		error:_logger.error,
		_logger:_logger
	});

	window.onerror = function(){
		$.error("client error", arguments);
		if(this.basicInfo.handleErrors !== false){
			if($.browser && $.browser.webkit){
				return true;
			}
			return false;
		}
	}


})(jQuery, window);


