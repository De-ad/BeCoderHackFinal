
function Form(){
    return(
    <div className="grid p-10 space-y-10 border-green-300 border-2 shadow-lg place-items-center rounded-lg w-fit ">
        <div className="text-green-300 text-center text-2xl"> Enter url</div>
        <div className=" place-self-center">
            <form className="w-96">
                <input
                type={"url"}
                placeholder="git repo url"
                className="w-full rounded text-center"
                />
            </form>
        </div> 
    </div>);

}

export default Form;