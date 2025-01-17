const CATEGORY_API_URL = "/api/category";
$("#category").addClass("active");
const id = $("#id");
const name = $("#name");
function openForm() {
    $("#id").val(null);
    $("#name").val(null);
    $("#myModal").modal("show");
    $(".modal-title").html("Add Category");
}

function saveCategory() {
    let data = {
        name: $("#name").val(),
        id: $("#id").val(),
    };

    let url =
        id.val() == null ? CATEGORY_API_URL : CATEGORY_API_URL + `/${id.val()}`;
    let method = id.val() == null ? "post" : "put";
    $.ajax({
        type: method,
        url: url,
        contentType: "application/json",
        data: JSON.stringify(data),
        success: function (response) {
            $("#myModal").modal("hide");
            location.reload();
        },
    });
}

function editForm(id) {
    $.ajax({
        type: "get",
        url: `${CATEGORY_API_URL}/${id}`,
        dataType: "json",
        success: function (response) {
            const data = response.data;
            openForm();
            $("#id").val(data.id);
            $("#name").val(data.name);
        },
    });
}

function deleteCategory(id) {
    $.ajax({
        type: "delete",
        url: `${CATEGORY_API_URL}/${id}`,
        contentType: "html",
        success: function (response) {
            alert("Delete Success");
            location.reload();
        },
    });
}
