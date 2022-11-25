import { Component } from "react";
import { trackPromise } from "react-promise-tracker";
import { tableAPI } from "./TableApi";
import { CommitTable } from "./CommitTable";
import { LoadButton } from "./LoadButton";

export class Results extends Component {
    constructor() {
      super();
      this.state = {
        commits: [],
      };

      this.onLoadTables = this.onLoadTables.bind(this);
    }
  
    onLoadTables() {
      let plus_url = document.getElementById("inpurl").value
      this.setState({
        commits: [],
      });
      trackPromise(
        tableAPI.fetchUsers(plus_url)
          .then((commits) => {
            this.setState({
              commits,
            })
          })
      );
    }

    handlesbm(e) {
      e.preventDefault();
    }
  
    render() {
      const line = "This web application checks which files from git have high risk of errors and who is the best reviewer to fix commit"
      return (
        <div>
          <div className="grid space-y-10 place-items-center">
          <div className="grid p-10 space-y-10 border-green-300 border-2 shadow-lg place-items-center rounded-lg w-fit">
            <div className="text-green-300 text-xl">{line}</div>
            <div className="text-green-300 text-center text-2xl"> Enter url</div>
            <div className=" place-self-center">
                <form className="w-96 grid place-items-center space-y-10" onSubmit={this.handlesbm}>
                    <input id="inpurl"
                    type={"url"}
                    placeholder="git repo url"
                    className="w-full rounded text-center"
                    // onChange={handleFormChange()}
                    // onSubmit={handleSubmit()}
                    />
                    {/* <button className="border-2 rounded-full p-1 px-4 shadow-lg text-green-300 border-green-300">Analyze</button> */}
                    <div className="flex items-center justify-center pb-8"><LoadButton
                      onLoad={this.onLoadTables}
                      title="Analyze"
                    /></div>
                </form>
            </div> 
          </div>
          
          <div className="tables">
            <CommitTable commits={this.state.commits} />
          </div>
          </div>
        </div>
      );
    }
  }