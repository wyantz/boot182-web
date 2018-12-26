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
		
		console.log(JSON.stringify(orangViewModel));
		
		
		$.ajax({
			type: 'post',
			url: namaKonteks + '/api/orang/',
			data: JSON.stringify(dataformatnyajson),
			dataType: 'json',
			contentType: 'application/json',
			success: function(d) {
				loadData();
			},
			error: function(d) {
				alert('gagal');
			}
		});
	}
	
	function submitAddAnak() {
		var dataformatnyajson = getFormData($('#formanakgue'));
		anak.push(dataformatnyajson);
	}
	
	function addAnak() {
		// tampilkan popup form tambah anak
		// di form tambah anak, ketika tombol submit diklik akan memanggil submitAddAnak()
	}
	</script>
</head>
<body>
        <div id="page-wrapper">
        	<form id="formgue">
        		<input type="text" name="nama">
        		<input type="text" name="alamat">
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
        <!-- /#page-wrapper -->
   <script>
   	$(document).ready(function() {
   		loadData();
   	});
   </script>
</body>
</html>