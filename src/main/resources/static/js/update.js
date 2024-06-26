// (1) 회원정보 수정
function update(userId, event) {
    event.preventDefault();
    let data = $("#profileUpdate").serialize();
    console.log(data);

    $.ajax({
        type: "put",
        url: `/api/user/${userId}`,
        data: data,
        contentType: "application/x-www-form-urlencoded; charset=utf-8",
        dataType: "json"
    }).done(res => {
        console.log("update 성공", res);
        alert("회원정보가 성공적으로 수정되었습니다.");
        location.href = `/user/${userId}`;
    }).fail(error => {
        if (error.data == null){
            alert(error.responseJSON.message);
        } else {
            alert("회원정보 수정에 실패하였습니다. 원인 : " +
                JSON.stringify(error.responseJSON.data));
        }
    });
}