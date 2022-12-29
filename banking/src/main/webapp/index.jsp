<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" prefix = "c" %>
<!DOCTYPE html>
<html>
<head>
    <title>Banking</title>
    <script src="https://cdnjs.cloudflare.com/ajax/libs/bootstrap/5.0.1/js/bootstrap.min.js" integrity="sha512-EKWWs1ZcA2ZY9lbLISPz8aGR2+L7JVYqBAYTq5AXgBkSjRSuQEGqWx8R1zAX16KdXPaCjOCaKE8MCpU0wcHlHA==" crossorigin="anonymous" referrerpolicy="no-referrer"></script>
    <link rel="stylesheet" href="https://cdnjs.cloudflare.com/ajax/libs/font-awesome/6.2.1/css/all.min.css" integrity="sha512-MV7K8+y+gLIBoVD59lQIYicR65iaqukzvf/nwasF0nqhPay5w/9lJmVM2hMDcnK1OnMGCdVK+iQrJ7lzPJQd1w==" crossorigin="anonymous" referrerpolicy="no-referrer" />
</head>
<body>
<div class="container-fluid">
    <div class="header-bar">
        <div class="row">
            <div class="col-md-6 col-lg-6 header-title">
                <h1>List of Customer </h1>
            </div>
            <div class="col-md-6 col-lg-6 header-list">
                <button type="submit">Transfer money Information</button>
                <button type="submit">
                    <a href="/index?action=create"><i class="fa fa-plus-square"></i>Add new customer</a>
                </button>
            </div>
        </div>
    </div>
    <div class="table-service">
            <table class="list-customer">
                <thead>
                <tr>
                    <th>#</th>
                    <th>FullName</th>
                    <th>Email</th>
                    <th>Phone</th>
                    <th>Address</th>
                    <th>Balance</th>
                    <th>Action</th>
                </tr>
                </thead>
                <tbody>
                    <tr>
                        <c:forEach items="${requestScope.customers}" var="customer">
                        <th scope="row">${customer.getId()}</th>
                        <td>${customer.getfullName()}</td>
                        <td>${customer.getEmail()}</td>
                        <td>${customer.getPhone()}</td>
                        <td>${customer.getAddress()}</td>
                        <td>${customer.getBalance()}</td>
                        </c:forEach>
                        <td>
                            <a href="/index?action=update&id=${index.getId()}"><i class="button-action fa fa-edit"></i></a>
                            <a href="/index?action=deposit"><i class="button-action fa fa-plus"></i></a>
                            <a href="/index?action=withdraw"><i class="button-action fa fa-minus"></i></a>
                            <a href="/index?action=transfer"><i class="button-action fa fa-exchange"></i></a>
                            <a href="/index?action=suspended"><i class="button-action fa fa-ban"></i></a>
                        </td>
                    </tr>
                </tbody>

            </table>
    </div>
</div>
</body>
</html>