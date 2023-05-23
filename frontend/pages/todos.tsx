import TodosView from "../views/TodosView/TodosView";
import { RouteProtector } from "./_app";

export default function TodosPage() {
  return (
    <RouteProtector>
      <TodosView />
    </RouteProtector>
  );
}
