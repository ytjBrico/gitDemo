let rootDiv;
export let init = function (div) {
	rootDiv = div;
	navItemLiClick();	//点击ul li 主菜单.
	testTable();	//bootStrapTable
}

function navItemLiClick () {
	rootDiv.find('.nav-item').on('click',function() {
		$('.nav-item').removeClass('nav-active').css('display', "none");
		$(this).addClass('nav-active');
		$('.nav-item not(.nav-item) .cm-treeview-menu').css("display", "none");
		//$(this).css("display", "block");

	});
}

function testTable() {
	$('#bootStrap_Table').bootstrapTable({
		url: 'queryUser',
		method: 'post',
		pagination: true,
		paginationLoop: true,
		sidePagination: 'server',
		pageList: [5, 10, 15, 20, 'All'],
		showRefresh: true,
		paginationPreText: '上一页',
		paginationNextText: '下一页',
		contentType: 'application/x-www-form-urlencoded;charset=UTF-8',
		cache: false,
		striped: true,
		locale: "zh-CN",
		//height: 20,
		rowStyle: function (row, index) {
            var style = {css:{'height':'20px'}};                
            return style;
        },   
        queryParams: function (params) {//自定义参数，这里的参数是传给后台的，我这是是分页用的  
        	//debugger;
        	return {//这里的params是table提供的  
                page: params.offset,//从数据库第几条记录开始  
                size: params.limit//找多少条  
            };  
        }, 
		pageNumber: 1,
		pageSize: 10,
		columns: [
			{field: 'ACTORNO',title: '用户码'},
			{field: 'ACTORNAME',title: '姓名'},
			{field: 'NICKNAME',title: '昵称'},
			{field: 'STATE',
			 title: '状态', 
			 formatter: function (value, row, index) {//自定义显示，这三个参数分别是：value该行的属性，row该行记录，index该行下标
		 					return value === '1' ? "正常" : value === '0' ? "请假" : "离职";
	 		 			}

			},
			{field: 'TELNUM',title: '电话号码'}
		]/*,
	    data: [{
	        id: 1,
	        name: 'Item 1',
	        price: '$1'
	    }, {
	        id: 2,
	        name: 'Item 2',
	        price: undefined
	    }]*/
	});
}




