import { Container } from "@mui/material";
import CreateTodoForm from "../../components/CreateTodoForm/CreateTodoForm";
import TodoList, { Todo } from "../../components/TodoList/TodoList";
import { useApi } from "../../hooks/useApi";

export default function TodosView() {
  const { data: todos, error, mutate } = useApi<Todo[]>({ path: "/todo/all-todos" });

  if (error) return <div>{error.message}</div>;

  return (
    <Container component="main" maxWidth="xs">
      <CreateTodoForm updateTodos={mutate} />
      <TodoList items={todos || []} />
    </Container>
  );
}
