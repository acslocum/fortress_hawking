
lines = File.open('pickup_lines.txt').readlines

exec "say", lines[rand(lines.size)]