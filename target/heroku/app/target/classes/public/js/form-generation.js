function endangeredForm() {
    //generate endangered From
    var eForm = document.getElementById("form-div");

    //add div for eName input
    var eNameDiv = document.createElement("div");
    eNameDiv.setAttribute("class", "txt_field");

    //add eName label to form
    var eNameLabel = document.createElement("label");
    eNameLabel.innerHTML = "Animal Name : ";
    eNameLabel.htmlFor = "eName";

    //add eName input to form
    var eName = document.createElement("input");
    eName.setAttribute("id", "eName");
    eName.setAttribute("name", "eName");
    eName.setAttribute("type", "text");
    eName.setAttribute("placeholder", "Enter animal name");

    //create eName input
    eNameDiv.appendChild(eNameLabel).appendChild(eName);

    //add div for eAge input
    var eAgeDiv = document.createElement("div");
    eAgeDiv.setAttribute("class", "form-group col-md-4");
    eAgeDiv.setAttribute("style", "width:200px;")

    //add eAge select to form
    var eAge = document.createElement("select");
    eAge.setAttribute("id", "eAge");
    eAge.setAttribute("name", "eAge");
    eAge.setAttribute("class", "form-control");
    eAge.setAttribute("type", "text");

    //add eAge label to form
    var eAgeLabel = document.createElement("label");
    eAgeLabel.setAttribute("for", "eAge");
    eAgeLabel.innerHTML = "Animal Age : ";
    eAgeLabel.htmlFor = "eAge";

    //add eAge value options to select
    var ageValues = ["Newborn", "Young", "Old"];
    for (const j of ageValues) {
        var eAgeOptions = document.createElement("option");
        eAgeOptions.setAttribute("value", j);
        eAgeOptions.text = j;
        eAge.appendChild(eAgeOptions);
    }

    //create eAge input
    eAgeDiv.appendChild(eAgeLabel).appendChild(eAge);

    //add div for eHealth input
    var eHealthDiv = document.createElement("div");
    eHealthDiv.setAttribute("class", "form-group col-md-4");
    eHealthDiv.setAttribute("style", "width:200px;")

    //add eHealth select to form
    var eHealth = document.createElement("select");
    eHealth.setAttribute("id", "eHealth");
    eHealth.setAttribute("name", "eHealth");
    eHealth.setAttribute("class", "form-control");
    eHealth.setAttribute("type", "text");

    //add eHealth label to form
    var eHealthLabel = document.createElement("label");
    eHealthLabel.setAttribute("for", "eHealth");
    eHealthLabel.innerHTML = "Animal Health : ";
    eHealthLabel.htmlFor = "eHealth";

    //add eHealth value options to select
    var healthValues = ["Healthy", "Okay", "Ill"];
    for (const i of healthValues) {
        var eHealthOptions = document.createElement("option");
        eHealthOptions.setAttribute("value", i);
        eHealthOptions.text = i;
        eHealth.appendChild(eHealthOptions);
    }

    //create eHealth input
    eHealthDiv.appendChild(eHealthLabel).appendChild(eHealth);

    //add div for location input
    var lNameDiv = document.createElement("div");
    lNameDiv.setAttribute("class", "form-group col-md-4");
    lNameDiv.setAttribute("style", "width:200px;")

    //add location select to form
    var lName = document.createElement("select");
    lName.setAttribute("id", "lName");
    lName.setAttribute("name", "lName");
    lName.setAttribute("class", "form-control");
    lName.setAttribute("type", "text");

    //add lName label to form
    var lNameLabel = document.createElement("label");
    lNameLabel.setAttribute("for", "lName");
    lNameLabel.innerHTML = "Location : ";
    lNameLabel.htmlFor = "lName";

    //add lName value options to select
    var locationValues = ["Zone A", "Zone B", "Zone C", "Zone D"];
    for (const l of locationValues) {
        var lNameOptions = document.createElement("option");
        lNameOptions.setAttribute("value", l);
        lNameOptions.text = l;
        lName.appendChild(lNameOptions);
    }

    //create lName input
    lNameDiv.appendChild(lNameLabel).appendChild(lName);

    //add submit input to form
    var eSubmit = document.createElement("input");
    eSubmit.setAttribute("type", "submit");
    eSubmit.setAttribute("value", "Add Animal");
    eSubmit.setAttribute("class", "btn btn-outline-success");
    eSubmit.setAttribute("onclick", "return validateE()");

    //add all inputs to form
    eForm.appendChild(eNameDiv);
    eForm.appendChild(eAgeDiv);
    eForm.appendChild(eHealthDiv);
    eForm.appendChild(lNameDiv);
    eForm.appendChild(eSubmit);

    //hide button after click
    document.getElementById("endg-btn").style.display = "none";
    document.getElementById("thrv-btn").style.display = "none";
    document.getElementById("anml-h4").style.display = "none";

    document.getElementById("rngr-id").style.display = "block";
    document.getElementById("dtl-h5").style.display = "block";
}

function validateE(){
    var y = document.getElementById("eName").value;
    if(y == "")
    {
        alert("Enter a Valid name")
        return false;
    };
}

function thrivingForm() {
    //generate animal From
    var form = document.getElementById("form-div");

    //add div for name input
    var nameDiv = document.createElement("div");
    nameDiv.setAttribute("class", "txt_field");

    //add name label to form
    var nameLabel = document.createElement("label");
    nameLabel.innerHTML = "Animal Name : ";
    nameLabel.htmlFor = "name";

    //add name input to form
    var name = document.createElement("input");
    name.setAttribute("id", "name");
    name.setAttribute("name", "name");
    name.setAttribute("type", "text");
    name.setAttribute("placeholder", "Enter animal name");

    //create name input
    nameDiv.appendChild(nameLabel).appendChild(name);

    //add div for location input
    var lNameDiv = document.createElement("div");
    lNameDiv.setAttribute("class", "form-group col-md-4");
    lNameDiv.setAttribute("style", "width:200px;")

    //add location select to form
    var lName = document.createElement("select");
    lName.setAttribute("id", "lName");
    lName.setAttribute("name", "lName");
    lName.setAttribute("class", "form-control");
    lName.setAttribute("type", "text");

    //add lName label to form
    var lNameLabel = document.createElement("label");
    lNameLabel.setAttribute("for", "lName");
    lNameLabel.innerHTML = "Location : ";
    lNameLabel.htmlFor = "lName";

    //add lName value options to select
    var locationValues = ["Zone A", "Zone B", "Zone C", "Zone D"];
    for (const l of locationValues) {
        var lNameOptions = document.createElement("option");
        lNameOptions.setAttribute("value", l);
        lNameOptions.text = l;
        lName.appendChild(lNameOptions);
    }

    //create lName input
    lNameDiv.appendChild(lNameLabel).appendChild(lName);

    //add submit input to form
    var submit = document.createElement("input");
    submit.setAttribute("type", "submit");
    submit.setAttribute("value", "Add Animal");
    submit.setAttribute("class", "btn btn-outline-success");
    submit.setAttribute("onclick", "return validate()");

    //add all inputs to form
    form.appendChild(nameDiv);
    form.appendChild(lNameDiv);
    form.appendChild(submit);

    //hide button after click
    document.getElementById("thrv-btn").style.display = "none";
    document.getElementById("endg-btn").style.display = "none";
    document.getElementById("anml-h4").style.display = "none";

    document.getElementById("rngr-id").style.display = "block";
    document.getElementById("dtl-h5").style.display = "block";
}

function validate(){
    var x = document.getElementById("name").value;
    if(x == "")
    {
        alert("Enter a Valid name")
        return false;
    };
}
