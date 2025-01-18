const PUBLISHER_API = "/api/publisher";
$("#publisher").addClass("active");

const getFormValue = () => ({
    id: $("#id").val(),
    name: $("#name").val(),
    address: $("#address").val(),
});

const openForm = (title = "Add Publisher", data = {}) => {
    $("#id").val(data.id || null);
    $("#name").val(data.name || null);
    $("#address").val(data.address || null);
    $(".modal-title").text(title);
    $("#myModal").modal("show");
};

const savePublisher = () => {
    const { id } = getFormValue();
    const method = id ? "put" : "post";
    const url = id ? `${PUBLISHER_API}/${id}` : PUBLISHER_API;

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
    $.getJSON(`${PUBLISHER_API}/${id}`, ({ data }) => {
        openForm("Edit Publisher", data);
    });
};

const deletePublisher = (id) => {
    $.ajax({
        type: "delete",
        url: `${PUBLISHER_API}/${id}`,
        success: () => {
            alert("Delete Success");
            location.reload();
        },
    });
};
