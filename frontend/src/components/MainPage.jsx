import Form from "./Form";
import Result from "./Result";

function MainPage(){

    return(
        <div className=" grid justify-items-center p-10 font-thin space-y-10"> 
            <Form />
            <Result />

        </div>
    );
}

export default MainPage;