const AUTHOR_API = "/api/author";
$("#category").addClass("active");

const getFormValue = () => ({
    id: $("#id").val(),
    name: $("#name").val(),
    publishedBooks: $("#publishedBooks").val(),
});

const openForm = (title = "Add Author", data = {}) => {
    $("#id").val(data.id || null);
    $("#name").val(data.name || null);
    $("#publishedBooks").val(data.publishedBooks || null);
    $(".modal-title").text(title);
    $("#myModal").modal("show");
};

const saveAuthor = () => {
    const { id } = getFormValue();
    const method = id ? "put" : "post";
    const url = id ? `${AUTHOR_API}/${id}` : AUTHOR_API;

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
    $.getJSON(`${AUTHOR_API}/${id}`, ({ data }) => {
        openForm("Edit Author", data);
    });
};

const deleteAuthor = (id) => {
    $.ajax({
        type: "delete",
        url: `${AUTHOR_API}/${id}`,
        success: () => {
            alert("Delete Success");
            location.reload();
        },
    });
};
