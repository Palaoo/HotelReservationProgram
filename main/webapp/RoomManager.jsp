<%@ page language="java" contentType="text/html; charset=EUC-KR"
	pageEncoding="EUC-KR"%>
<!DOCTYPE html>
<html lang="en">

<head>
<meta charset="UTF-8">
<meta http-equiv="X-UA-Compatible" content="IE=edge">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/css/bootstrap.min.css"
	rel="stylesheet"
	integrity="sha384-1BmE4kWBq78iYhFldvKuhfTAU6auU8tT94WrHftjDbrCEXSU1oBoqyl2QvZ6jIW3"
	crossorigin="anonymous">
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.1.3/dist/js/bootstrap.bundle.min.js"
	integrity="sha384-ka7Sk0Gln4gmtz2MlQnikT1wXgYsOg+OMhuP+IlRH9sENBO0LRn5q+8nbTov4+1p"
	crossorigin="anonymous"></script>
<link rel="stylesheet" href="RoomManager.css">
<title>Document</title>
</head>

<body style="padding-top: 30px;">
	<h4>
		&nbsp;&nbsp;<a href=ReservationManager.jsp
			style="text-decoration-line: none">예약관리</a> <a href="RoomManager.jsp">객실관리</a>
	</h4>

	<div>
		<div class="d-flex flex-column mb-3 div1 border border-primary"
			style="margin-left: 20px">
			<div class="p-2">객실목록</div>
			<div class="p-2">
				<select class="form-select" aria-label="Default select example"
					name="" id="roomList" size="12" style="width: 99%; height: 400px;">
				</select>
			</div>
		</div>
		<div class="d-flex flex-column mb-3 div1 border border-primary"
			style="margin-left: 20px; padding-top: 100px;">
			<div class="p-2 input-group flex-nowrap">
				<div class="div2" style="width: 30%;">&nbsp;객실명</div>
				<div style="width: 70%;" class="input-group mb-3">
					<input style="width: 200px;" type="text" class="form-control"
						aria-label="Recipient's username" aria-describedby="basic-addon2"
						id='roomName'>
				</div>
			</div>
			<div class="p-2 input-group flex-nowrap" style="height: 70px">
				<div class="div2" style="width: 30%;">&nbsp;객실종류</div>
				<div class="div2" style="width: 70%;">
					<select class="form-select" aria-label="Default select example"
						name="" id="roomType" size="1" style="width: 99%; height: 40px;">
						<option value="empty"></option>
						<option value="SuiteRoom">SuiteRoom</option>
						<option value="FamilyRoom">FamilyRoom</option>
						<option value="SuperiorRoom">SuperiorRoom</option>
						<option value="DeluxeRoom">DeluxeRoom</option>
						<option value="ExecutiveRoom">ExecutiveRoom</option>
						<option value="SingleRoom">SingleRoom</option>
						<option value="DoubleRoom">DoubleRoom</option>
					</select>
				</div>
			</div>
			<div class="p-2 input-group flex-nowrap">
				<div class="div2" style="width: 30%;">&nbsp;숙박가능인원</div>
				<div style="width: 70%;" class="input-group mb-3">
					<input style="width: 85%;" type="text" class="form-control"
						aria-label="Recipient's username" aria-describedby="basic-addon2"
						id='availPerson'> <span style="width: 15%;"
						class="input-group-text">명</span>
				</div>
			</div>
			<div class="p-2 input-group flex-nowrap">
				<div class="div2" style="width: 30%;">&nbsp;1박요금</div>
				<div style="width: 70%;" class="input-group mb-3">
					<input style="width: 200px;" type="text" class="form-control"
						aria-label="Recipient's username" aria-describedby="basic-addon2"
						id='fee'>
				</div>
			</div>
			<div class="p-2" style="padding-bottom: 20px;">
				<div class="div2" style="width: 30%; margin-left: 30px;">
					<button class="btn btn-primary btn-sm" id='btnAppendRoom'>등록</button>
				</div>
				<div class="div2" style="width: 30%;">
					<button class="btn btn-primary btn-sm" id='btnRemove'>삭제</button>
				</div>
				<div class="div2" style="width: 30%;">
					<button class="btn btn-primary btn-sm" id='btnReset'>비우기</button>
				</div>
			</div>
		</div>
	</div>
</body>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<script>
	$(document).ready(init()).on('click', '#btnAppendRoom', function() { // 객실 등록
		if ($(this).text() == '등록')
			appendRoom(); // 객실 등록
		else
			updateRoom();

	}).on('click', '#roomList', function() { // 객실 선택/수정 
		$('#btnAppendRoom').text('수정');
		let str = $(this).find('option:selected').text()
		let str1 = str.split(', ');
		$('#roomName').val(str1[0]);
		$('#roomType').val($.trim(str1[1]));
		$('#availPerson').val(str1[2]);
		$('#fee').val(str1[3]);
	}).on('click', '#btnReset', function() { // 리셋
		$('#btnAppendRoom').text('등록');
		$('#roomName').val('');
		$('#roomType').val('empty');
		$('#availPerson').val('');
		$('#fee').val('');
	}).on('click', '#btnRemove', function() {
		deleteRoom();
	})

	function deleteRoom() {
		$.ajax({
			type : 'get',
			url : 'deleteRoom',
			data : {
				roomNum : $('#roomList option:selected').val()
			},
			success : function() {
				loadRoomList();
				$('#btnReset').trigger('click');
			},
			error : function() {
			}
		})
	}

	function updateRoom() {
		$.ajax({
			type : 'get',
			url : 'updateRoom',
			data : {
				roomNum : $('#roomList option:selected').val(),
				roomName : $('#roomName').val(),
				roomType : $('#roomType option:selected').val(),
				availPerson : $('#availPerson').val(),
				fee : $('#fee').val()
			},
			success : function() {
				loadRoomList();
				$('#btnReset').trigger('click');
			},
			error : function() {
			}
		})
	}

	function appendRoom() { // 객실 등록
		$.ajax({
			type : 'get',
			url : 'appendRoom',
			data : {
				roomName : $('#roomName').val(),
				roomType : $('#roomType option:selected').val(),
				availPerson : $('#availPerson').val(),
				fee : $('#fee').val()
			},
			success : function() {
				loadRoomList();
				$('#btnReset').trigger('click');
			},
			error : function() {
			}
		})
	}

	function init() { // ready()에서 호출 
		loadRoomList(); // 객실 리스트 받아오기
	}

	function loadRoomList() { // 객실 리스트 받아오기
		$.ajax({
			type : 'get',
			url : 'loadRoomList',
			dataType : 'json',
			success : function(data) {
				displayRoomList(data); // 객실목록 display
			},
			error : function() {
			}
		})
	}

	function displayRoomList(data) { // 객실목록 display
		console.log(data);
		$('#roomList').empty();
		for (let i = 0; i < data.length; i++) {
			let jo = data[i];
			$('#roomList').append(
					'<option value=' + jo['roomNum'] + '>' + jo['roomName']
							+ ', ' + jo['roomType'] + ', ' + jo['availPerson']
							+ ', ' + jo['fee'] + '</option>');
		}
	}
</script>
</html>