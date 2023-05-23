import * as React from "react";
import AppBar from "@mui/material/AppBar";
import Box from "@mui/material/Box";
import Toolbar from "@mui/material/Toolbar";
import Typography from "@mui/material/Typography";
import Button from "@mui/material/Button";
import IconButton from "@mui/material/IconButton";
import MenuIcon from "@mui/icons-material/Menu";
import { getAuth, signOut } from "firebase/auth";
import { useRouter } from "next/router";
import Link from "next/link";

export default function Header() {
  const router = useRouter();
  return (
    <Box sx={{ flexGrow: 1 }}>
      <AppBar position="static">
        <Toolbar>
          <IconButton
            size="large"
            edge="start"
            color="inherit"
            aria-label="menu"
            sx={{ mr: 2 }}
          >
            <MenuIcon />
          </IconButton>
          <Typography variant="h6" component="div" sx={{ flexGrow: 1 }}>
            <Link href="/todos">Todo app</Link>
          </Typography>
          <Button
            color="inherit"
            onClick={() => {
              const auth = getAuth();
              signOut(auth)
                .then(() => {
                  router.push("/");
                })
                .catch((error) => {
                  console.error(error);
                });
            }}
          >
            Log out
          </Button>
          <Link href="/sign-up">
            <Button sx={{ color: "white" }}>Sign up</Button>
          </Link>
          <Link href="/sign-in">
            <Button sx={{ color: "white" }}>Sign in</Button>
          </Link>
        </Toolbar>
      </AppBar>
    </Box>
  );
}
