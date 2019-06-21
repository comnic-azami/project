<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
<head>
	<meta http-equiv="Content-Type" content="text/html; charset=utf-8" />
<!--
	<meta http-equiv="Content-Type" content="text/html; charset=Shift_JIS" />
-->

	<link href="http://calil.jp/public/css/calilapi.css" rel="stylesheet" type="text/css" />


	<title>library_test</title>

</head>
<body>
<div id ="title">
<h2>図書検索へようこそ!<br>
${account.userName} <p>さん</p></h2>
</div>


<div id="content">

	<!-- 選択 -->
	<div id="library" >
		<h2>選択している図書館: <strong id="pref_name"></strong></h2>
		<br>
		市町村から図書館を選択:		
		<span id="library_change" style="font-size: 85%;"> (<a href="javascript:city_selector.showDlg();">図書館変更</a>)</span>
	</div>
	
	<div id="change_lib" >
		登録している図書館の市町村の変更:
		<strong id="registration_library"> ${library.place}</strong>
		<span id="library_change" style="font-size: 85%;"> (<a href="javascript:city_selector.showDlg();">図書館変更</a>)</span>
	</div>

	<!-- ISBNリスト -->
	<h4>あなたのBook List:</h4>
	<div id = booklist>
		<table class="highlight responsive-table">
				<tr>
					<th></th>
					<th>ISBN</th>
					<th>TITLE</th>
					<th>AUTHOR</th>
				</tr>
				<c:forEach var="book" items="${bookList}">
					<tr>
						<td><img src="img/${book.isbn}.webp" width="65px" height="15%"></td>
						<td>${book.isbn}</td>
						<td>${book.title}</td>
						<td>${book.author.name}</td>
						<td><fmt:formatNumber value="${book.price}" type="CURRENCY" currencyCode="USD" /></td>
					</tr>
				</c:forEach>
		</table>
	</div>
	
	<!-- ここでデータベースから本のリストを持ってくる -->
	<select name="" id="isbn_list" size=2>
		<option value="9784403671586,9784065102497,99784088725093" selected>9784403671586,9784065102497,9784088725093</option>
	</select>
　　　<!-- ここまでデータベースから本のリストを持ってくる -->

	<!-- 結果の表示 -->
	<div id="calil_booklist" class="clearfix">
	</div>
</div>

<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
<script type="text/javascript" src="http://calil.jp/public/js/calilapi.js">	
</script>
<script type="text/javascript">
	//デフォルトの図書館ID(sysytemid)
	
	//デフォルトは登録した図書館を表示したい」
	var systemid_list = ['Tokyo_Setagaya'];
	//市町村選択時に実行される関数
	function on_select_city(systemid, pref){
		systemid_list = systemid;
		log(systemid_list);
		//選択市町村の表示
		$('#pref').show();
		$('#pref_name').html(pref);
		apishow();
	}
	var city_selector = {};
	$(function(){
		//市町村選択ダイアログ
		city_selector = new CalilCitySelectDlg({
			'appkey' : '2bc265ea827cb23b11d1ee80a25ef575',
			'select_func' : on_select_city
		});
		apishow();
		//ISBNリスト選択時
		$('#isbn_list').change(apishow);
	});
	//図書館APIの検索結果の表示
	function apishow(){
		
		var isbn_list = $('#isbn_list').val().split(',');
		$('#calil_booklist').html('');
		$(isbn_list).each(function(i, isbn){
			//Amazonの書影
			var thumbnail = '<a href="http://www.amazon.co.jp/exec/obidos/ASIN/' + isbn + '" target="_blank"><img border="0" src="https://images-na.ssl-images-amazon.com/images/P/' + isbn +'.09.MZZZZZZ.jpg" style="" alt="" onload="if(this.width==\'1\') this.src=\'/public/img/no-image/middle.gif\'"></a>';
			//検索結果表示場所の追加
			$('#calil_booklist').append('<div class="calil_book">'+ thumbnail + '<div id="'+isbn+'"></div></div>');
		});
		//検索表示用のインスタンス作成
		var calil = new Calil({
			'appkey' : '2bc265ea827cb23b11d1ee80a25ef575',
			'render': new CalilRender(),
			'isbn' : isbn_list,
			'systemid' : systemid_list
		});
		//検索結果の表示 結果は↑で生成した<div id="isbn"></div>に描画されます
		calil.search();
	}
	
	
</script>





</body>


</html>