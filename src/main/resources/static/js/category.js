const CATEGORY_API = "/api/category";
$("#category").addClass("active");

const getFormValue = () => ({
    id: $("#id").val(),
    name: $("#name").val(),
});

const openForm = (title = "Add Category", data = {}) => {
    $("#id").val(data.id || null);
    $("#name").val(data.name || null);
    $(".modal-title").text(title);
    $("#myModal").modal("show");
};

const saveCategory = () => {
    const { id } = getFormValue();
    const method = id ? "put" : "post";
    const url = id ? `${CATEGORY_API}/${id}` : CATEGORY_API;

    $.ajax({
        type: method,
        url,
        contentType: "application/json",
        data: JSON.stringify(getFormValue()),
        success: () => {
            $("#myModal").modal("hide");
            location.reload();
        },
    });
};

const editForm = (id) => {
    $.getJSON(`${CATEGORY_API}/${id}`, ({ data }) => {
        openForm("Edit Category", data);
    });
};

const deleteCategory = (id) => {
    $.ajax({
        type: "delete",
        url: `${CATEGORY_API}/${id}`,
        success: () => {
            alert("Delete Success");
            location.reload();
        },
    });
};
