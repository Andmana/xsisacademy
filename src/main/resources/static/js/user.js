function openForm() {
    $.ajax({
        type: "get",
        url: "/user/form",
        contentType: "html",
        success: function (response) {
            $("#myModal").modal("show");
            $(".modal-title").html("Add user");
            $(".modal-body").html(response);
        },
    });
}

function editForm(id) {
    $.ajax({
        type: "get",
        url: `/user/edit/${id}`,
        contentType: "html",
        success: function (response) {
            $("#myModal").modal("show");
            $(".modal-title").html("Edit user");
            $(".modal-body").html(response);
        },
    });
}

function deleteUser(id) {
    $.ajax({
        type: "get",
        url: `/user/delete/${id}`,
        contentType: "html",
        success: function (response) {
            location.reload();
        },
    });
}
