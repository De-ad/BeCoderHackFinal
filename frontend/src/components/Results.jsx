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
      this.setState({
        commits: [],
      });
  
      trackPromise(
        tableAPI.fetchUsers()
          .then((commits) => {
            this.setState({
              commits,
            })
          })
      );
          
      ;
    }
    render() {
      return (
        <div>
          <LoadButton
            onLoad={this.onLoadTables}
            title="Load tables"
          
          />
          <div className="tables">
            <CommitTable commits={this.state.commits} />
          </div>
        </div>
      );
    }
  }