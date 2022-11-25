 import { LoadButton } from "./LoadButton";
import { Results } from "./Results";
 export default function Form(){
    const line = "This web application checks which files from git have high risk of errors and who is the best reviewer to fix commit"
    
    return(
    <div className="grid p-10 space-y-10 border-green-300 border-2 shadow-lg place-items-center rounded-lg w-fit">
        <div className="text-green-300 text-xl">{line}</div>
        <div className="text-green-300 text-center text-2xl"> Enter url</div>
        <div className=" place-self-center">
            <form className="w-96 grid place-items-center space-y-10">
                <input
                type={"url"}
                placeholder="git repo url"
                className="w-full rounded text-center"
                />
                {/* <button className="border-2 rounded-full p-1 px-4 shadow-lg text-green-300 border-green-300">Analyze</button> */}
                
            </form>
        </div> 
    </div>);

}

