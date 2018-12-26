<%@ taglib uri="http://java.sun.com/jstl/core_rt" prefix="c" %>
<html>
<head>
	<title>Main</title>
	<script>
	var result = '';
	var orangViewModel = {};
	var anak = [];
	function prosesarraynya(i, e) {
		result += '<tr>';
		result += '<td>'+e.nama+'</td>';
		result += '<td>'+e.alamat+'</td>';
		result += '</tr>';		
	}
	
	function tampilkanYaaaa(x) {
		result = '';
		$(x).each(prosesarraynya);
		$('#tbodyorang').html(result);
	}
	
	function loadData() {
		$.ajax({
			type: 'get',
			url: namaKonteks + '/api/orang/',
			success: function(apapun) {
				tampilkanYaaaa(apapun);
			}
		});
	}
	
	function simpanData() {
		var dataformatnyajson = getFormData($('#formgue'));

		orangViewModel.orangTua = dataformatnyajson;		
		orangViewModel.anak = anak;

		$.ajax({
			type: 'post',
			url: namaKonteks + '/api/orang/',
			data: JSON.stringify(orangViewModel),
			dataType: 'json',
			contentType: 'application/json',
			success: function(d) {
				loadData();
				$('#tbodyanak').html('');
				$('#nama,#alamat').val('');
				anak = [];
			},
			error: function(d) {
				alert('gagal');
			}
		});
	}
	
	function submitAddAnak() {
		var dataformatnyajson = {};
		dataformatnyajson.nama = $('#namaAnak').val();
		dataformatnyajson.alamat = $('#alamatAnak').val();
		anak.push(dataformatnyajson);
		$('#modalForm').modal('hide');
		$('#namaAnak, #alamatAnak').val('');
		showAnak();
	}
	
	function addAnak() {
		// tampilkan popup form tambah anak
		$('#modalForm').modal('show');
	}
	
	function showAnak() {
		var resultRowAnak = '';
		$(anak).each(function(i, e) {
			resultRowAnak += '<tr>';
			resultRowAnak += '<td>'+e.nama+'</td>';
			resultRowAnak += '<td>'+e.alamat+'</td>';
			resultRowAnak += '</tr>';		
		});
		$('#tbodyanak').html(resultRowAnak);
	}
	</script>
</head>
<body>
     <div id="page-wrapper">
     	<form id="formgue">
     		<input type="text" name="nama" id="nama">
     		<input type="text" name="alamat" id="alamat">
     		<button class="btn btn-primary" type="button" onclick="simpanData()">Simpan</button>
     		<button class="btn btn-warning" type="button" onclick="addAnak()">Tambah Anak</button>
     	</form>
     	<div class="row">
                 <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                     <thead>
                         <tr>
                             <th>Nama</th>
                             <th>Alamat</th>
                         </tr>
                     </thead>
                     <tbody id="tbodyanak">

                     </tbody>
                 </table>
     	</div>
         <div class="row">
             <div class="col-lg-12">
                 <h1 class="page-header">Tables</h1>
             </div>
             <!-- /.col-lg-12 -->
                 <table width="100%" class="table table-striped table-bordered table-hover" id="dataTables-example">
                     <thead>
                         <tr>
                             <th>Nama</th>
                             <th>Alamat</th>
                         </tr>
                     </thead>
                     <tbody id="tbodyorang">

                     </tbody>
                 </table>
        <button class="btn btn-primary" onclick="test()">Test</button>
         </div>
     </div>

	<div class="modal fade" id="modalForm" tabindex="-1" role="dialog" aria-labelledby="myModalLabel" aria-hidden="true">
		<div class="modal-dialog" role="document">
			<div class="modal-content">
				<div class="modal-header text-center">
					<h4 class="modal-title w-100 font-weight-bold">Tambah Anak</h4>
					<button type="button" class="close" data-dismiss="modal"
						aria-label="Close">
						<span aria-hidden="true">&times;</span>
					</button>
				</div>
				<div class="modal-body mx-3">
					<div class="md-form mb-5">
						<label data-error="wrong" data-success="right" for="defaultForm-email">Nama</label>
						<input type="text" id="namaAnak" class="form-control validate">
					</div>

					<div class="md-form mb-4">
						<label data-error="wrong" data-success="right" for="defaultForm-pass">Alamat</label>
						<input type="text" id="alamatAnak" class="form-control validate">
					</div>

				</div>
				<div class="modal-footer d-flex justify-content-center">
					<button class="btn btn-default" onclick="submitAddAnak()">Tambah</button>
				</div>
			</div>
		</div>
	</div>

	<div class="text-center">
		<a href="" class="btn btn-default btn-rounded mb-4" data-toggle="modal" data-target="#modalLoginForm">Launch Modal Login Form</a>
	</div>
    <!-- /#page-wrapper -->
   <script>
   	$(document).ready(function() {
   		loadData();
   	});
   </script>
</body>
</html>