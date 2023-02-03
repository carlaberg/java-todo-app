import { Container } from "@mui/material";
import { useState } from "react";
import CreateTodoForm from "../../components/CreateTodoForm/CreateTodoForm";
import TodoList from "../../components/TodoList/TodoList";

const mockListItems = [
  {
    text: "Clean the house",
  },
  {
    text: "Walk the dog",
  },
  {
    text: "Buy groceries",
  },
];

export default function TodosPage() {
  const [items, setItems] = useState(mockListItems);

  return (
    <Container component="main" maxWidth="xs">
      <CreateTodoForm />
      <TodoList items={items} />
    </Container>
  );
}
