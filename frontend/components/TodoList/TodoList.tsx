import * as React from "react";
import CssBaseline from "@mui/material/CssBaseline";
import Box from "@mui/material/Box";
import { createTheme, ThemeProvider } from "@mui/material/styles";
import {
  Divider,
  List,
  ListItem,
  ListItemButton,
  ListItemText,
} from "@mui/material";
import Input from "@mui/material/Input";
import DeleteOutlineIcon from "@mui/icons-material/DeleteOutline";
import { apiFetcher } from "../../hooks/useApi";
import { mutate } from "swr";

export interface Todo {
  id: string;
  text: string;
}

interface TodoListProps {
  items: Todo[];
}

const theme = createTheme();

export default function TodoList({ items }: TodoListProps) {
  const updateTodo = async (id: string, text: string) => {
    const itemToUpdate = items.findIndex((item) => item.id === id);
    const itemsBefore = items.slice(0, itemToUpdate);
    const itemsAfter = items.slice(itemToUpdate + 1);
    const newItem = { id, text };
    const newItems = [...itemsBefore, newItem, ...itemsAfter];
    
    mutate("/todo/all-todos", newItems, false);

    await apiFetcher({
      path: `/todo/update/${id}`,
      body: newItem,
      method: "PUT",
    });
  };

  return (
    <ThemeProvider theme={theme}>
      <CssBaseline />
      <Box
        sx={{
          marginTop: 8,
          display: "flex",
          flexDirection: "column",
          alignItems: "center",
        }}
      >
        <List
          sx={{
            width: "100%",
          }}
        >
          {items.map(({ text, id }) => (
            <span key={id}>
              <ListItem disablePadding sx={{ display: "flex" }}>
                <Input
                  value={text}
                  onChange={(e) => updateTodo(id, e.target.value)}
                />
                <ListItemButton
                  sx={{ flexGrow: "0" }}
                  onClick={async () => {
                    await apiFetcher({
                      path: `/todo/delete/${id}`,
                      method: "DELETE",
                    });
                    mutate("/todo/all-todos");
                  }}
                >
                  <DeleteOutlineIcon />
                </ListItemButton>
              </ListItem>
              <Divider />
            </span>
          ))}
        </List>
      </Box>
    </ThemeProvider>
  );
}
