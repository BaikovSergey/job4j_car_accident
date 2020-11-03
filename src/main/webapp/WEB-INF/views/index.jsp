<%@ page contentType="text/html; charset=UTF-8" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jstl/core" %>
<!doctype html>
<html lang="en">
<head>
    <meta http-equiv="Content-Type" content="text/html;charset=UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <link rel="stylesheet" href="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/css/bootstrap.min.css">
    <script src="https://ajax.googleapis.com/ajax/libs/jquery/3.5.1/jquery.min.js"></script>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/popper.js/1.16.0/umd/popper.min.js"></script>
    <script src="https://maxcdn.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"></script>

    <!-- Bootstrap CSS -->
    <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.4.1/css/bootstrap.min.css"
          integrity="sha384-Vkoo8x4CGsO3+Hhxv8T/Q5PaXtkKtu6ug5TOeNV6gBiFeWPGFN9MuhOf23Q9Ifjh" crossorigin="anonymous">
    <script src="https://cdn.jsdelivr.net/npm/popper.js@1.16.0/dist/umd/popper.min.js"
            integrity="sha384-Q6E9RHvbIyZFJoft+2mJbHaEWldlvI9IOYy5n3zV9zzTtmI3UksdQRVvoxMfooAo" crossorigin="anonymous"></script>
    <script src="https://stackpath.bootstrapcdn.com/bootstrap/4.5.2/js/bootstrap.min.js"
            integrity="sha384-wfSDF2E50Y2D1uUdj0O3uMBJnjuUD4Ih7YwaYd1iqfktj0Uod8GCExl3Og8ifwB6" crossorigin="anonymous"></script>

    <title>Car accidents</title>

    <script>

        function fillAccidentsTable(path) {
            $("#allAccidents tbody").empty();
            $.getJSON(path, function (data) {
                for (var i = 0; i < data.length; i++) {
                    $('#allAccidents > tbody:last-child').append('<tr><td style="display: none" id="accidentId">'+data[i].id+'</td><td id="accidentName">'+data[i].name+'</td><td id="accidentText">'+data[i].text+'</td> <td id="accidentAddress">'+data[i].address+'</td><td><div class="btn-group btn-group-sm"><button type="button" class="btn btn-primary dropdown-toggle" data-toggle="dropdown">Options</button><div class="dropdown-menu"><a class="dropdown-item" id="btn-update">Edit</a><a class="dropdown-item" id="btn-delete">Delete</a></div></div></td></tr>');
                }
            });
        }

        $(document).ready(function () {
            $("#allAccidents").on("click", "#btn-update", function () {
                var $row = $(this).closest("tr");
                var $id = $row.find("td:nth-child(1)").text().trim();
                var $name = $row.find("td:nth-child(2)").text().trim();
                var $text = $row.find("td:nth-child(3)").text().trim();
                var $address = $row.find("td:nth-child(4)").text().trim();
                window.location.replace("<c:url value='/update'/>" + "?id=" + $id + "&name=" + $name
                + "&text=" + $text + "&address=" + $address);
            });
        });

        $(document).ready(function () {
            $("#allAccidents").on("click", "#btn-delete", function () {
                var $row = $(this).closest("tr");
                var $id = $row.find("td:nth-child(1)").text().trim();
                $.post( "<c:url value='/delete'/>", { id: $id} );
                fillAccidentsTable("<c:url value='/getAllAccidents'/>");
            });

        });

        $(document).ready(function () {
            fillAccidentsTable("<c:url value='/getAllAccidents'/>");
        });

    </script>
</head>
<body>
<div class="container">
    <div class="card" style="width: 100%">
        <div class="card-header">
            <div class="d-flex flex-row-reverse">
                <div class="p-2">Login as : ${user.username}</div>
            </div>
        </div>
        <div class="card-body">
            <div class="container pt-2">
                <a href="<c:url value='/create'/>" class="btn btn-success btn-lg">Add new accident</a>
            </div>
            <div class="container pt-1">
                <table class="table" id="allAccidents" style="table-layout: fixed">
                    <thead class="thead-light">
                    <tr>
                        <th style="display: none">Id</th>
                        <th style="width: 30%">Name</th>
                        <th style="width: 30%">Text</th>
                        <th style="width: 30%">Address</th>
                        <th style="width: 10%"></th>
                    </tr>
                    </thead>
                    <tbody>

                    </tbody>
                </table>
            </div>
        </div>
        <div class="card-footer">

        </div>
    </div>
</div>
</body>
</html>