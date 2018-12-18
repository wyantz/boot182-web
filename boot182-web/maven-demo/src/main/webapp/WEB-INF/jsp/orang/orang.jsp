<html>
<head>
	<title>Main</title>
</head>
<body>
        <div id="page-wrapper">
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
                                <tbody>
			<c:forEach items="${budiList}" var="ol">
				<tr>
					<td>${ol.nama}</td>
					<td>${ol.alamat}</td>
				</tr>
			</c:forEach>
                                </tbody>
                            </table>
            </div>
        </div>
        <!-- /#page-wrapper -->
</body>
</html>