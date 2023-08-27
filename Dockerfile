FROM alpine:3.14

ENV HOME_EX=/to-do-list

WORKDIR $HOME_EX

COPY ./to-do-list $HOME_EX

CMD ["./run.sh"]