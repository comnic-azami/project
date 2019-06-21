<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html>
	<head>
	<!-- このリンクは市町村の図を表示させるcss -->
		<link href="http://calil.jp/public/css/calilapi.css" rel="stylesheet" type="text/css" />

		<meta charset="UTF-8">
		<title>アカウント登録</title>
	<style>
		
	
	</style>
	
	
	
	</head>
	<body class="">
		<div class="container">
			<h2>アカウントを登録する</h2>
			<div class="row">
				<form class="col s12" action="sign-up.do" method="post">
				   	<div class="row">
						<div id="change_lib" >
							登録する図書館の市町村:<h2><strong id="pref_name"> </strong></h2>
							<strong id="test_name">
							<br>
							
							<span id="library_change" style="font-size: 85%;"> (<a href="javascript:city_selector.showDlg();">図書館変更</a>)</span>
						</div>
					</div>
				
					<div class="row">
						<div class="input-field col s6">
							<input id="user_name" name="userName" type="text" class="validate" 
							       placeholder="input your name" autofocus required>
							<label for="user_name">Username</label>
						</div>
					</div>
					<div class="row">
						<div class="input-field col s12">
							<input id="password" name="password1" type="password"
								   class="validate" required>
							<label for="password">Password</label>
						</div>
						<div class="input-field col s12">
							<input id="password" name="password2" type="password"
								   class="validate" required>
						    <label for="password">Password</label>
						</div>
					</div>
			
					<input class="btn waves-effect #d7ccc8 brown lighten-4"
						   type="submit" value="アカウント登録">
					<p class="red-text darken-2">${error}</p>
				</form>
			</div>
		</div>
		
		<script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/jquery/1.11.1/jquery.min.js"></script>
		<script type="text/javascript" src="http://calil.jp/public/js/calilapi.js">			
		</script>
		<script type="text/javascript">								
		
			
			//市町村選択時に実行される関数
			function on_select_city(systemid, pref){
				systemid_list = systemid;
				
				//選択市町村の表示
				console.log(systemid_list);
				$('#test_name').html(systemid);
				$('#pref_name').html(pref);
				
			}
			var city_selector = {};
			$(function(){
				//市町村選択ダイアログ
				city_selector = new CalilCitySelectDlg({
					'appkey' : '2bc265ea827cb23b11d1ee80a25ef575',
					'select_func' : on_select_city
				});
				
			});
			
			//デバッグ用関数
			
		</script>
		
	</body>
</html>