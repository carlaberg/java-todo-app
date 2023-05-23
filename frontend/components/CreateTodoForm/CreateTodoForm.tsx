import * as React from "react";
import Button from "@mui/material/Button";
import CssBaseline from "@mui/material/CssBaseline";
import TextField from "@mui/material/TextField";
import Box from "@mui/material/Box";
import Typography from "@mui/material/Typography";
import { createTheme, ThemeProvider } from "@mui/material/styles";
import { Todo } from "../TodoList/TodoList";
import { apiFetcher, useApi } from "../../hooks/useApi";
import { sharedFetch } from "../../lib/sharedFetch";
import { json } from "stream/consumers";

const theme = createTheme();

interface CrreateTodoFormProps {
  updateTodos: () => {};
}
export default function CreateTodoForm({ updateTodos }: CrreateTodoFormProps) {
  const handleSubmit = async (event: React.FormEvent<HTMLFormElement>) => {
    event.preventDefault();
    const data = new FormData(event.currentTarget);

    await apiFetcher({
      path: "/todo/create",
      method: "POST",
      body: {
        text: data.get("text").toString(),
      },
    });

    updateTodos();
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
        <Typography component="h1" variant="h5">
          Add todo
        </Typography>
        <Box
          component="form"
          onSubmit={handleSubmit}
          noValidate
          sx={{ mt: 1, width: "100%" }}
        >
          <TextField
            margin="normal"
            required
            fullWidth
            id="text"
            label="Todo text"
            name="text"
            autoComplete="text"
            autoFocus
          />
          <Button
            type="submit"
            fullWidth
            variant="contained"
            sx={{ mt: 3, mb: 2 }}
          >
            Add
          </Button>
        </Box>
      </Box>
    </ThemeProvider>
  );
}
