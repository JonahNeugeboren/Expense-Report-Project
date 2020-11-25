function drawTable() {
    let xhr = new XMLHttpRequest();
    //console.log(xhr);
    
    var table_div = document.getElementById('table_div');
    var tbl = document.createElement("table");

    xhr.onreadystatechange = function() {
        if(xhr.readyState === 4 & xhr.status === 200){
            let values = JSON.parse(xhr.response);
            console.log(values);
            

            var header_row = document.createElement("tr");
            var report_id_cell = document.createElement("td");
            var report_id_cell_text = document.createTextNode("Report ID");
            report_id_cell.appendChild(report_id_cell_text);
            header_row.appendChild(report_id_cell);

            var user_id_cell = document.createElement("td");
            var user_id_cell_text = document.createTextNode("User ID");
            user_id_cell.appendChild(user_id_cell_text);
            header_row.appendChild(user_id_cell);

            var manager_id_cell = document.createElement("td");
            var manager_id_cell_text = document.createTextNode("Manager ID");
            manager_id_cell.appendChild(manager_id_cell_text);
            header_row.appendChild(manager_id_cell);

            var amount_cell = document.createElement("td");
            var amount_cell_text = document.createTextNode("Amount");
            amount_cell.appendChild(amount_cell_text);
            header_row.appendChild(amount_cell);

            var image_cell = document.createElement("td");
            var image_cell_text = document.createTextNode("Image");
            image_cell.appendChild(image_cell_text);
            header_row.appendChild(image_cell);

            var approved_cell = document.createElement("td");
            var approved_cell_text = document.createTextNode("Approved");
            approved_cell.appendChild(approved_cell_text);
            header_row.appendChild(approved_cell);

            tbl.appendChild(header_row);

            if(values != null) {
                for (let value of values) {
                    var row = document.createElement("tr");
                    var cell1 = document.createElement("td");
                    var cellText1 = document.createTextNode(value._report_id);
                    cell1.appendChild(cellText1);
                    row.appendChild(cell1);

                    var cell2 = document.createElement("td");
                    var cellText2 = document.createTextNode(value._user_id);
                    cell2.appendChild(cellText2);
                    row.appendChild(cell2);

                    var cell3 = document.createElement("td");
                    var cellText3 = document.createTextNode(value._manager_id);
                    cell3.appendChild(cellText3);
                    row.appendChild(cell3);

                    var cell4 = document.createElement("td");
                    var cellText4 = document.createTextNode(value._amount);
                    cell4.appendChild(cellText4);
                    row.appendChild(cell4);

                    var cell5 = document.createElement("td");
                    var cellImage = new Image();
                    cellImage.style.maxWidth = "200px";
                    cellImage.src = 'data:image/png;base64,' + value._image;
                    cell5.appendChild(cellImage);
                    row.appendChild(cell5);

                    var cell6 = document.createElement("td");
                    var cellText6 = document.createTextNode(value._approved);
                    cell6.appendChild(cellText6);
                    row.appendChild(cell6);

                    tbl.appendChild(row);
                }
            }
            if (document.getElementById("table_div").childNodes.length > 0) {
                console.log("hello");
            } else { 
                table_div.appendChild(tbl);
            }
        }
    }

    xhr.open('GET', '../ExpenseReportServlet/LoadTableHelper');
    xhr.send();
}

function get_user(values) {
    console.log(values);
    hide_approve_form(values);
    set_user_attributes(values);

}

function set_user_attributes(user) {
    document.getElementById("fname").innerText = "First Name: " + user._fname + ",";
    document.getElementById("lname").innerText = "Last Name: " + user._lname + ",";
    document.getElementById("email").innerText = "Email: " + user._email;
}


function hide_approve_form(user) {
    if(user._type != "manager") {
        document.getElementById("admin_panel").style.visibility = "hidden"
    }
}

function start() {
    let xhr = new XMLHttpRequest();
    xhr.onreadystatechange = function() {
        if(xhr.readyState === 4 & xhr.status === 200){
            let values = JSON.parse(xhr.response);
            get_user(values);
        }
    }
    xhr.open('GET', '../ExpenseReportServlet/GetUser');
    xhr.send();


    drawTable();
}

window.onload=start;  
document.getElementById('fname_form').addEventListener("submit", start());
document.getElementById('lname_form').addEventListener("submit", start());
document.getElementById('email_form').addEventListener("submit", start());
document.getElementById('password_form').addEventListener("submit", start());