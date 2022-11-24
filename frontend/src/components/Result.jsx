const table_style = "px-5 text-green-300 font-thin";

export default function Result(){
    return(
        <div className="grid p-10 space-y-10 border-green-300 border-2 shadow-lg place-items-center rounded-lg w-fit ">
        <div className="text-green-300 text-center text-2xl"> High risk of errors in commits:</div>
        <table className="table-fixed">
        <thead>
                <tr>
                <th className= {table_style}>Commit name</th>
                <th className= {table_style}>Author</th>
                <th className= {table_style}>Better to be reviewed by</th>
                </tr>
            </thead>
            <tbody>
            
            </tbody>
        </table>
        <div></div>
    </div>
    );
}


