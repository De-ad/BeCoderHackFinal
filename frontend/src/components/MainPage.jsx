import Form from "./Form";
import { Results } from "./Results";

function MainPage(){
    return(
        <div className=" grid justify-items-center p-10 font-thin space-y-10"> 
            <Form />
            <Results />
        </div>
    );
}

export default MainPage;