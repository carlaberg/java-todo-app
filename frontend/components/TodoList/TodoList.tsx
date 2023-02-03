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

interface Todo {
  text: string;
}

interface TodoListProps {
  items: Todo[];
}

const theme = createTheme();

export default function TodoList({ items }: TodoListProps) {
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
          {items.map(({ text }) => (
            <>
              <ListItem disablePadding>
                <ListItemButton>
                  <ListItemText primary={text} />
                </ListItemButton>
              </ListItem>
              <Divider />
            </>
          ))}
        </List>
      </Box>
    </ThemeProvider>
  );
}
