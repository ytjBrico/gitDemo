let rootDiv;
export let init = function (div) {
	rootDiv = div;
	subAct();	//点击登录
	
}

function subAct () {
	rootDiv.find('#log_act').on('click',function() {
		window.location.href = "test6";

	});
}



