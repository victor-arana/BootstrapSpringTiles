<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html> <!-- ENCODING HTML 5, necessary for bootstrap -->
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Example Application Spring and Bootstrap</title>

<script src="resources/js/jquery-2.2.3.min.js"></script>
<script src="resources/js/bootstrap/js/bootstrap.js"></script>
<script src="resources/js/bootstrap/js/moment.js"></script>
<script type="text/javascript" src="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.js"></script>
<link rel="stylesheet" href="resources/js/bootstrap/css/bootstrap.min.css">
<link rel="stylesheet" type="text/css" href="https://cdn.datatables.net/v/dt/dt-1.10.12/datatables.min.css"/>
<script src="resources/jsRocket/storeAdm.js"></script>

</head>
<body>

<div class="container">
	<h2>Stores list</h2>

	<form class="form-horizontal" role="form">
		<div class="form-group">
			<label class="control-label col-sm-2" for="storeNumber">Store Number:</label>
			<div class="col-sm-10">
				<input type="number" class="form-control" id="storeNumber" placeholder="123">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="countryCode">Country Code:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="countryCode" placeholder="12">
			</div>
		</div>
		<div class="form-group">
			<label class="control-label col-sm-2" for="storeName">Store Name:</label>
			<div class="col-sm-10">
				<input type="text" class="form-control" id="storeName" placeholder="Balbuena">
			</div>
		</div>
		<div class="form-group">

		</div>
		<div class="form-group">
			<label class="btn btn-info btn-file">
				<span class="glyphicon glyphicon-file"></span> Load File
			    <input type="file" style="display: none;">
			</label>
			<button type="button" id="buttonInsert" class="btn btn-success">
				<span class="glyphicon glyphicon-plus-sign"></span> Insert Store
			</button>
			<button type="button" id="buttonDelete" class="btn btn-warning">
				<span class="glyphicon glyphicon-minus-sign"></span> Delete Store
			</button>
		</div>
		<div>
			<table id="tableStore" class="table table-bordered table-striped">
				<thead>
					<tr>
						<th class="col-sm-1" data-field="id">Id</th>
						<th class="col-sm-1" data-field="checkDelete"></th>
						<th class="col-sm-3" data-field="storeNumber">Store Number</th>
						<th class="col-sm-3" data-field="countryCode">Country Code</th>
						<th class="col-sm-2" data-field="storeName">Store Name</th>
					</tr>
				</thead>
			</table>
		</div>
	</form>
</div>


</body>
</html>