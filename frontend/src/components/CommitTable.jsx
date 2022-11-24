import { Table } from "./Table";
import { Header } from "./Header";
import { Row } from "./Row";


export const CommitTable = (props) => (
    <Table
      items={props.commits}
      headerRender={Header}
      rowRender={Row}
    />
  );