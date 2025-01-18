const BOOK_API = "/api/book";
const AUTHOR_API = "/api/author/search";
$("#book").addClass("active");

const getFormValue = () => ({
    id: $("#id").val(),
    title: $("#title").val(),
    publishedYear: $("#publishedYear").val(),
});

const openForm = (title = "Add Book", data = {}) => {
    $("#id").val(data.id || null);
    $("#title").val(data.title || null);
    $("#publishedYear").val(data.publishedYear || null);
    $(".modal-title").text(title);
    $("#myModal").modal("show");
};

const saveBook = () => {
    const { id } = getFormValue();
    const method = id ? "put" : "post";
    const url = id ? `${BOOK_API}/${id}` : BOOK_API;

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
    $.getJSON(`${BOOK_API}/${id}`, ({ data }) => {
        openForm("Edit Book", data);
    });
};

const deleteBook = (id) => {
    $.ajax({
        type: "delete",
        url: `${BOOK_API}/${id}`,
        success: () => {
            alert("Delete Success");
            location.reload();
        },
    });
};
