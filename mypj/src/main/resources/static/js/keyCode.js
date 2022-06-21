let prevText = "";
let keyCode = "";
let keyLength = 100;

function keyUp() {
    //window.onkeydown = (e) => console.log(e);
    window.onkeydown= (e) => returnKeyCode(e.code.toString());
    // console.log(keyCode);
    if (document.getElementById("textLength").value < keyLength) {
        textCount();
        prevText = document.getElementById("inputDescription").value;
    }
    else if(keyCode === 'Backspace'){
        textCount();
    }
    else{
        alert("글자 수 초과!");
        document.getElementById("inputDescription").value = prevText;
        textCount();
    }
}
function textCount(){
    document.getElementById("textLength").value = document.getElementById("inputDescription").value.length;
}
function returnKeyCode(e){
    keyCode = e;
}