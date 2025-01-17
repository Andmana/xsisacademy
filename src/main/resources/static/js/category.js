function openForm() {
    $.ajax({
        type: "get",
        url: "/category/form",
        contentType: "html",
        success: function (response) {
            $("#myModal").modal("show");
            $(".modal-title").html("Add Category");
            $(".modal-body").html(response);
        },
    });
}

function editForm(id) {
    $.ajax({
        type: "get",
        url: `/category/edit/${id}`,
        contentType: "html",
        success: function (response) {
            $("#myModal").modal("show");
            $(".modal-title").html("Edit Category");
            $(".modal-body").html(response);
        },
    });
}

function deleteCategory(id) {
    $.ajax({
        type: "get",
        url: `/category/delete/${id}`,
        contentType: "html",
        success: function (response) {
            location.reload();
        },
    });
}

$("#category").addClass("active");
