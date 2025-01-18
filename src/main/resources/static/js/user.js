const USER_API = "/api/user";
$("#user").addClass("active");

const getFormValue = () => ({
    id: $("#id").val(),
    name: $("#name").val(),
    phoneNumber: $("#phoneNumber").val(),
    address: $("#address").val(),
});

const openForm = (title = "Add User", data = {}) => {
    $("#id").val(data.id || null);
    $("#name").val(data.name || null);
    $("#phoneNumber").val(data.phoneNumber || null);
    $("#address").val(data.address || null);
    $(".modal-title").text(title);
    $("#myModal").modal("show");
};

const saveUser = () => {
    const { id } = getFormValue();
    const method = id ? "put" : "post";
    const url = id ? `${USER_API}/${id}` : USER_API;

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
    $.getJSON(`${USER_API}/${id}`, ({ data }) => {
        openForm("Edit User", data);
    });
};

const deleteUser = (id) => {
    $.ajax({
        type: "delete",
        url: `${USER_API}/${id}`,
        success: () => {
            alert("Delete Success");
            location.reload();
        },
    });
};
