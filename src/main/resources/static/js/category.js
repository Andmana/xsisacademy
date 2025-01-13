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
