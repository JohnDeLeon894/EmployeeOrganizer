$(document).ready(function () {



    let list1 = document.getElementById('dept_id');

    list1.options[0] = new Option('--Select--', "0");
    list1.options[1] = new Option('Tech', "1");
    list1.options[2] = new Option('HR', "2");
    list1.options[3] = new Option('Fin', "3");
    list1.options[4] = new Option('Mar', "4");
    list1.options[5] = new Option('Prod', "5");
});

$("#dept_id").change(function getJobTitle(){

    let list1 = document.getElementById("dept_id");
    let list2 = document.getElementById("job_id");
    let list1SelectedValue = list1.options[list1.selectedIndex].value;

    if (list1SelectedValue ==='0')
    {

        list2.options.length=0;
        list2.options[0] = new Option('--Select--', '');

    }
    else if (list1SelectedValue ==='1')
    {

        list2.options.length=0;
        list2.options[0] = new Option('Pro', "4");
        list2.options[1] = new Option('SPro', "5");

    }
    else if (list1SelectedValue ==='2')
    {

        list2.options.length=0;
        list2.options[0] = new Option('clerk', "1");
        list2.options[1] = new Option('Admin', "2");
        list2.options[2] = new Option('LAdmin', "3");

    }else if (list1SelectedValue ==='3')
    {

        list2.options.length=0;
        list2.options[0] = new Option('Acc', "8");
        list2.options[1] = new Option('LAcc', "9");

    }else if (list1SelectedValue ==='4')
    {

        list2.options.length=0;
        list2.options[0] = new Option('Consult', "10");

    }else if (list1SelectedValue ==='5')
    {

        list2.options.length=0;
        list2.options[0] = new Option('ProA', "6");
        list2.options[1] = new Option('SProA', "7");

    }
});