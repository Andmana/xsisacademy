const API = {
    BOOK: "/api/book",
    AUTHOR: "/api/author/search",
    CATEGORY: "/api/category/search",
    PUBLISHER: "/api/publisher/search",
};

$("#book").addClass("active");

const getFormValue = () => ({
    id: $("#id").val(),
    title: $("#title").val(),
    publishedYear: $("#publishedYear").val(),
    authorId: $("#authorId").val(),
    categoryId: $("#categoryId").val(),
    publisherId: $("#publisherId").val(),
});

const openForm = (title = "Add Book", data = {}) => {
    const setSelectOption = (selector, option) => {
        $(selector).html(
            option
                ? `<option value="${option.id}" selected="selected">${option.name}</option>`
                : null
        );
    };

    $("#id").val(data.id || null);
    $("#title").val(data.title || null);
    $("#publishedYear").val(data.publishedYear || null);

    setSelectOption("#authorId", data.author);
    setSelectOption("#categoryId", data.category);
    setSelectOption("#publisherId", data.publisher);

    $(".modal-title").text(title);
    $("#myModal").modal("show");
};

const saveBook = () => {
    const { id } = getFormValue();
    const method = id ? "put" : "post";
    const url = id ? `${API.BOOK}/${id}` : API.BOOK;

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
    $.getJSON(`${API.BOOK}/${id}`, ({ data }) => openForm("Edit Book", data));
};

const deleteBook = (id) => {
    $.ajax({
        type: "delete",
        url: `${API.BOOK}/${id}`,
        success: () => {
            alert("Delete Success");
            location.reload();
        },
    });
};

const setupSelect2 = (selector, apiUrl) => {
    $(selector).select2({
        theme: "bootstrap-5",
        width:
            $(selector).data("width") ||
            ($(selector).hasClass("w-100") ? "100%" : "style"),
        placeholder: $(selector).data("placeholder"),
        allowClear: true,
        dropdownParent: $("#myModal"),
        ajax: {
            url: apiUrl,
            dataType: "json",
            data: (params) => ({ name: params.term }),
            processResults: ({ data }) => ({
                results: data.map((item) => ({
                    id: item.id,
                    text: item.name,
                })),
            }),
        },
    });
};

$(document).ready(() => {
    setupSelect2("#authorId", API.AUTHOR);
    setupSelect2("#categoryId", API.CATEGORY);
    setupSelect2("#publisherId", API.PUBLISHER);
});
