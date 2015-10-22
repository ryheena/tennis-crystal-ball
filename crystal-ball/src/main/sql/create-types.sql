CREATE TYPE tournament_level AS ENUM ('G', 'F', 'M', 'A', 'D', 'O', 'C', 'T');
CREATE TYPE surface AS ENUM ('H', 'C', 'G', 'P');
CREATE TYPE player_hand AS ENUM ('R', 'L');
CREATE TYPE player_backhand AS ENUM ('1', '2');
CREATE TYPE tournament_event_result AS ENUM ('RR', 'R128', 'R64', 'R32', 'R16', 'QF', 'SF', 'BR', 'F', 'W');
CREATE TYPE match_round AS ENUM ('RR', 'R128', 'R64', 'R32', 'R16', 'QF', 'SF', 'BR', 'F');
CREATE TYPE tournament_entry AS ENUM ('Q', 'WC', 'LL', 'PR');
CREATE TYPE match_outcome AS ENUM ('RET', 'W/O');
