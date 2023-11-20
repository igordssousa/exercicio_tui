# Exercicio TUI

## How to run

```bash
docker compose up web
```

## Endpoints

`GET /quotes/{id}`

Returns 200 + Quote if found, 404 if nothing found

`GET /quotes?author={author}&page={page}&size={size}`

All query parameters are optional. If no `author` is sent, will list all quotes available.

## Why very little testing?

Most of the code used had very little logic and used out-of-the-box solutions

## Time spent
 About a workday's worth bootstraping the app from scratch (had nothing installed in the computer)
 
 About 2h to complete the main functionality

 Another 2h for improvements