//
//
// export default function ResultTable(props){
//
//     const table_style = "px-5 text-green-300 font-thin";
//     const { commits } = props
//
//     return (!props || props.length === 0) ?
//     (<div className="grid p-10 space-y-10 border-green-300 border-2 shadow-lg place-items-center rounded-lg w-fit ">
//         <div> No data </div>
//     </div>) :
//     (
//         <div className="grid p-10 space-y-10 border-green-300 border-2 shadow-lg place-items-center rounded-lg w-fit ">
//         <div className="text-green-300 text-center text-2xl"> High risk of errors in commits:</div>
//         <table className="table-fixed">
//         <thead>
//                 <tr>
//                 <th className= {table_style}>Commit name</th>
//                 <th className= {table_style}>Author</th>
//                 <th className= {table_style}>Better to be reviewed by</th>
//                 </tr>
//             </thead>
//             <tbody>
//                 {
//                     commits.map((commit) =>
//                     <tr key={commit.id}>
//                         <td>commit.commitname</td>
//                         <td>commit.reviewer</td>
//                     </tr>
//                     )
//                 }
//             </tbody>
//         </table>
//         <div className=" bg-white h-96">
//             <div>test</div>
//
//         </div>
//     </div>
//     );
// }


