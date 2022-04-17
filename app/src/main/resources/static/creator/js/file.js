import changeEvent from "./js/changeEvent";
import isValidation from "./js/isValidation";
import handleUpdate from "./js/handleUpdate";
import "./css/reset.css";
import "./css/style.css";
import "./css/upload.css";

const input = document.getElementById("input");
const initLabel = document.getElementById("label");

input.addEventListener("change", (event) => {
    const files = changeEvent(event);
    const isValidFiles = isValidation(files);
    handleUpdate(isValidFiles);
});

initLabel.addEventListener("mouseover", (event) => {
    event.preventDefault();
    const label = document.getElementById("label");
    label ? .classList.add("label--hover");
});

initLabel.addEventListener("mouseout", (event) => {
    event.preventDefault();
    const label = document.getElementById("label");
    label ? .classList.remove("label--hover");
});

document.addEventListener("dragenter", (event) => {
    event.preventDefault();
    console.log("dragenter");
    if (event.target.className === "inner") {
        event.target.style.background = "#616161";
    }
});

document.addEventListener("dragover", (event) => {
    console.log("dragover");
    event.preventDefault();
});

document.addEventListener("dragleave", (event) => {
    event.preventDefault();
    console.log("dragleave");
    if (event.target.className === "inner") {
        event.target.style.background = "#3a3a3a";
    }
});

document.addEventListener("drop", (event) => {
    event.preventDefault();
    console.log("drop");
    if (event.target.className === "inner") {
        const files = event.dataTransfer ? .files;
        const isValidFiles = isValidation(files);
        handleUpdate(isValidFiles);
        event.target.style.background = "#3a3a3a";
    }
});