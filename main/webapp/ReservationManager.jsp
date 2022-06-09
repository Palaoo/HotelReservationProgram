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
<link rel="stylesheet" href="ReservationManager.css">
<title>Document</title>
</head>

<body style="padding-top: 30px;">
	<h4>
		&nbsp;&nbsp;<a href=ReservationManager.jsp>예약관리</a> <a
			href=RoomManager.jsp
			"
            style="text-decoration-line: none">객실관리</a>
	</h4>
	<div class='border border-primary div'
		style="height: 650px; padding-top: 25px;">
		<div class="d-flex flex-column mb-3">
			<div class="p-2 input-group flex-nowrap">
				<div class="div2" style="width: 20%;">&nbsp;숙박기간</div>
				<div style="width: 80%;" class="input-group mb-3">
					<input type="date" class="form-control" placeholder="Username"
						aria-label="Username" id=searchStayLength1> <span
						class="input-group-text">~</span> <input type="date"
						class="form-control" placeholder="Server" aria-label="Server"
						id=searchStayLength2>
				</div>
			</div>
			<div class="p-2 input-group flex-nowrap">
				<div class="div2" style="width: 30%;">&nbsp;숙박인원</div>
				<div style="width: 70%;" class="input-group mb-3">
					<input style="width: 200px;" type="text" class="form-control"
						aria-label="Recipient's username" aria-describedby="basic-addon2"
						id='searchExp_Men'> <span class="input-group-text">명</span>
				</div>
			</div>
			<div style="height: auto;" class="p-2">
				<div class="div2" style="width: 30%">&nbsp객실종류</div>
				<div class="div2" style="width: 70%;">
					<select class="form-select" aria-label="Default select example"
						name="" id="searchRoomType" size="1" style="width: 90%;">
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
			<div style="height: auto; padding-right: 20px;" class="p-2">
				<button class="btn btn-primary btn-sm" style="float: right;"
					id='btnSearchAvailRoom'>찾기</button>
			</div>
			<div style="height: 70%; text-align: center;" class="p-2">
				<select class="form-select" aria-label="Default select example"
					name="" id="roomList" size="15" style="width: 100%;">
				</select>
			</div>
		</div>
	</div>
	<div class="border border-primary div" style="height: 650px;">
		&nbsp
		<div class="d-flex flex-column mb-3">
			<div class="p-2 input-group flex-nowrap">
				<div class="div2" style="width: 30%;">&nbsp;예약번호</div>
				<div style="width: 70%;" class="input-group mb-3">
					<input style="width: 200px;" type="text" class="form-control"
						aria-label="Recipient's username" aria-describedby="basic-addon2"
						id="reservationID">
				</div>
			</div>
			<div class="p-2 input-group flex-nowrap">
				<div class="div2" style="width: 30%;">&nbsp;객실명</div>
				<div style="width: 70%;" class="input-group mb-3">
					<input style="width: 200px;" type="text" class="form-control"
						aria-label="Recipient's username" aria-describedby="basic-addon2"
						id="roomName">
				</div>
			</div>
			<div class="p-2 input-group flex-nowrap">
				<div class="div2" style="width: 30%;">&nbsp;객실종류</div>
				<div style="width: 70%;" class="input-group mb-3">
					<input style="width: 200px;" type="text" class="form-control"
						aria-label="Recipient's username" aria-describedby="basic-addon2"
						id="roomType">
				</div>
			</div>
			<div class="p-2 input-group flex-nowrap">
				<div class="div2" style="width: 30%;">&nbsp;숙박예정인원</div>
				<div style="width: 70%;" class="input-group mb-3">
					<input style="width: 200px;" type="text" class="form-control"
						aria-label="Recipient's username" aria-describedby="basic-addon2"
						id="exp_Men"> <span class="input-group-text">명</span>
				</div>
			</div>
			<div class="p-2 input-group flex-nowrap">
				<div class="div2" style="width: 20%;">&nbsp;숙박기간</div>
				<div style="width: 80%;" class="input-group mb-3">
					<input type="date" class="form-control" placeholder="Username"
						aria-label="Username" id="stayLength1" readonly> <span
						class="input-group-text">~</span> <input type="date"
						class="form-control" placeholder="Server" aria-label="Server"
						id="stayLength2" readonly>
				</div>
			</div>
			<div class="p-2 input-group flex-nowrap">
				<div class="div2" style="width: 30%;">&nbsp;예약자</div>
				<div style="width: 70%;" class="input-group mb-3">
					<input style="width: 200px;" type="text" class="form-control"
						aria-label="Recipient's username" aria-describedby="basic-addon2"
						id="booker">
				</div>
			</div>
			<div class="p-2 input-group flex-nowrap">
				<div class="div2" style="width: 30%;">&nbsp;모바일</div>
				<div style="width: 70%;" class="input-group mb-3">
					<input style="width: 200px;" type="text" class="form-control"
						aria-label="Recipient's username" aria-describedby="basic-addon2"
						id="mobile">
				</div>
			</div>
			<div class="p-2 input-group flex-nowrap">
				<div class="div2" style="width: 30%;">&nbsp;숙박총액</div>
				<div style="width: 70%;" class="input-group mb-3">
					<input style="width: 200px;" type="text" class="form-control"
						aria-label="Recipient's username" aria-describedby="basic-addon2"
						id="totalFee"> <span class="input-group-text">원</span>
				</div>
			</div>
			<div class="p-2">
				<div class="div2" style="width: 33%; text-align: center;">
					<button class="btn btn-primary btn-sm"
						style="width: 80%; height: 30px;" id="btnBook">예약등록</button>
				</div>
				<div class="div2" style="width: 33%; text-align: center;">
					<button class="btn btn-primary btn-sm"
						style="width: 80%; height: 30px;" id="btnCancel">예약취소</button>
				</div>
				<div class="div2" style="width: 33%; text-align: center;">
					<button class="btn btn-primary btn-sm"
						style="width: 80%; height: 30px;" id="btnReset">비우기</button>
				</div>
			</div>
		</div>
	</div>
	<div class="border border-primary div"
		style="height: 650px; padding-top: 20px;">
		<div class="d-flex flex-column mb-3">
			<div class="p-2" style="padding-left: 20px;">&nbsp예약내역</div>
			<div class="p-2" style="text-align: center;">
				<select class="form-select" aria-label="Default select example"
					name="" id="bookRoomList" size="25" style="width: 100%;">
				</select>
			</div>
		</div>
	</div>

</body>
<script src="https://code.jquery.com/jquery-3.5.1.js"></script>
<script src="https://code.jquery.com/ui/1.13.1/jquery-ui.js"></script>
<script>
	$(document).ready().on(
			'click',
			'#btnSearchAvailRoom',
			function() { // 예약가능 room 찾기 버튼
				let str = $('#searchStayLength1').val().split('-');
				let str1 = str[0] + str[1] + str[2];
				str = $('#searchStayLength2').val().split('-');
				str1 = str1 + '~' + str[0] + str[1] + str[2];
				loadAvailRoom(str1, $('#searchExp_Men').val(), $(
						'#searchRoomType option:selected').text());
				init();
			}).on(
			'click',
			'#bookRoomList', // 예약내역 클릭시
			function() {
				$('#btnBook').text('예약수정');
				let str = $(this).find('option:selected').text().split(' ');
				
				$('#roomName').val(str[0])
				$('#roomType').val(str[1])
				let str1 = str[2].split('~');
				console.log(str1[0])
				str1[0] = str1[0].slice(0, 4) + '-' + str1[0].slice(4, 6) + '-'
						+ str1[0].slice(6, 8);
				str1[1] = str1[1].slice(0, 4) + '-' + str1[1].slice(4, 6) + '-'
						+ str1[1].slice(6, 8);
				$('#stayLength1').val(str1[0])
				$('#stayLength2').val(str1[1])
				$('#booker').val(str[3])
				
				let str2=$(this).find('option:selected').val().split('/');
				$('#reservationID').val(str2[0])
				$('#exp_Men').val(str2[1])
				$('#mobile').val(str2[2])
				$('#totalFee').val(str2[3])
			}).on('click', '#roomList', function() {
		$('#btnBook').text('예약등록');
		let data = $(this).find('option:selected').text().split(' ');
		$('#roomName').empty();
		$('#roomName').val(data[0]);
		$('#roomType').val(data[1]);
		$('#exp_Men').val($('#searchExp_Men').val());
		let ar1 = $('#searchStayLength1').val().split('-')
		let ar2 = $('#searchStayLength2').val().split('-')
		let da1 = new Date(ar1[0], ar1[1], ar1[2]);
		let da2 = new Date(ar2[0], ar2[1], ar2[2]);
		const diffDate = da1.getTime() - da2.getTime();
		const dateDays = Math.abs(diffDate / (1000 * 3600 * 24));
		console.log(data[2])
		console.log(dateDays)
		$('#totalFee').val(data[3] * dateDays);
		$('#stayLength1').val($('#searchStayLength1').val())
		$('#stayLength2').val($('#searchStayLength2').val())
	}).on('click', '#btnBook', function() { // 예약등록
		if ($('#btnBook').text() == '예약등록')
			appendReservation();
		else
			updateReservation();
	}).on('click', '#btnReset', function() { // 비우기
		$('#btnBook').text('예약등록');
		$('#reservationID').val('')
		$('#roomName').val('')
		$('#roomType').val('')
		$('#exp_Men').val('')
		$('#stayLength1').val('')
		$('#stayLength2').val('')
		$('#booker').val('')
		$('#mobile').val('')
		$('#totalFee').val('')
	}).on('click', '#btnCancel', function() {
		cancelReservation();
	})

	function updateReservation() {
		$.ajax({
			type : 'get',
			url : 'updateReservation',
			data : {
				reservationID : $('#reservationID').val(),
				exp_Men : $('#exp_Men').val(),
				stayLength : preTreat(),
				booker : $('#booker').val(),
				mobile : $('#mobile').val()
			},
			success : function() {
				init();
				$('#btnReset').trigger('click');
			},
			error : function() {
			}
		})
	}

	function cancelReservation() {
		if ($('#reservationID').val() != null)
			$.ajax({
				type : 'get',
				url : 'cancelReservation',
				data : {
					reservationID : $('#reservationID').val()
				},
				success : function() {
					init();
					$('#btnReset').trigger('click');
				},
				error : function() {
					alert('cancelReservationServlet 호출 실패');
				}
			})
	}

	function appendReservation() { // 예약등록
		$.ajax({
			type : 'get',
			url : 'appendReservation',
			data : {
				roomName : $('#roomName').val(),
				roomType : $('#roomType').val(),
				roomNum : $('#roomList option:selected').val(),
				exp_Men : $('#exp_Men').val(),
				stayLength : preTreat(),
				totalFee : $('#totalFee').val(),
				booker : $('#booker').val(),
				mobile : $('#mobile').val()
			},
			success : function() {
				init();
				$('#btnReset').trigger('click');
				$('#btnSearchAvailRoom').trigger('click');
			},
			error : function() {
				alert('appendReservationServlet 호출 실패')
			}
		})
	}

	function init() {
		loadBookRoom();
	}

	function loadBookRoom() {
		$.ajax({
			type : 'get',
			url : 'loadBookRoom',
			data : {
				stayLength : preTreat2(),
				exp_Men : $('#searchExp_Men').val(),
				roomType : $('#searchRoomType option:selected').val()
			},
			dataType : 'json',
			success : function(data) {
				displayBookRoom(data);
			},
			error : function() {
			}
		})
	}

	function loadAvailRoom(stayLength1, exp_Men1, roomType1) {
		$.ajax({
			type : 'get',
			url : 'loadAvailRoom',
			data : {
				stayLength : stayLength1,
				exp_Men : exp_Men1,
				roomType : roomType1
			},
			dataType : 'json',
			success : function(data) {
				console.log('The data from loadAvailRoomServlet' + data);
				displayAvailRoom(data);
			},
			error : function() {
				alert('loadAvailRoomServlet 호출 실패')
			}
		})
	}

	function displayBookRoom(data) {
		$('#bookRoomList').empty();
		for (let i = 0; i < data.length; i++) {
			let jo = data[i];
			$('#bookRoomList')
					.append(
							'<option value=' + jo['reservationID'] +'/'+jo['exp_Men']+  '/' + jo['totalFee']+ '/'
							+ jo['mobile']+'>'
									+ jo['roomName']
									+ ' '
									+ jo['roomType']
									+ ' '
									+ jo['stayLength']
									+ ' '
									+ jo['booker'] + '</option>');
		}
	}

	function displayAvailRoom(data) {
		$('#roomList').empty();
		for (let i = 0; i < data.length; i++) {
			let jo = data[i];
			$('#roomList').append(
					'<option value='+jo['roomNum']+'>' + jo['roomName'] + ' '
							+ jo['roomType'] + ' ' + jo['availPerson'] + ' '
							+ jo['fee'] + '</option>');
		}
	}

	function preTreat() {
		let date1 = $('#stayLength1').val().split('-')
		let date2 = $('#stayLength2').val().split('-')
		return date1[0] + date1[1] + date1[2] + '~' + date2[0] + date2[1]
				+ date2[2];
	}

	function preTreat2() {
		let date1 = $('#searchStayLength1').val().split('-')
		let date2 = $('#searchStayLength2').val().split('-')
		return date1[0] + date1[1] + date1[2] + '~' + date2[0] + date2[1]
				+ date2[2];
	}
</script>
</html>